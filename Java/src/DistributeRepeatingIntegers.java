import java.util.ArrayList;
import java.util.Collections;

public class DistributeRepeatingIntegers {
	
	public boolean canDistribute(int[] nums, int[] quantity) {
        int[] count = new int[1001];
        for(int i : nums) count[i]++;
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < count.length; i++) {
        	if(count[i] > 0) l.add(count[i]);
        }
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for(int i : quantity) {
        	if(l.contains(i)) {
        		l.remove((Integer)i);
        	}else {
        		orders.add(i);
        	}
        }
        
        if(orders.isEmpty()) return true;
        
        Collections.sort(l);
        Collections.sort(orders);
        
        int[] n = l.stream().mapToInt(i -> i).toArray();
        int[] order = orders.stream().mapToInt(i -> i).toArray();
        
        return helper(orders.size()-1, n, order);
    }
	
	
	private boolean helper(int i, int[] l, int[] orders) {
		if(i < 0) return true;
		int o = orders[i];
		
		for(int j = 0; j < l.length; j++) {
			if(l[j] >= o) {
				l[j] -= o;
				if(helper(i-1, l, orders)) return true;
				l[j] += o;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		DistributeRepeatingIntegers test = new DistributeRepeatingIntegers();
		System.out.println(test.canDistribute(new int[] {1,1,1,1,1}, new int[] {2,3}));
	}
	
}
