import java.util.HashMap;

public class MaximumEqualFrequency {
	
	public int maxEqualFreq(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res = 1;
        for(int i = 0; i < nums.length; i++) {
        	int old = counts.getOrDefault(nums[i], 0);
        	counts.put(nums[i], old+1);
        	
        	if(old != 0) {
        		int n = map.get(old)-1;
        		if(n > 0)
        			map.put(old, n);
        		else
        			map.remove(old);
        	}
        	map.put(old+1, map.getOrDefault(old+1, 0)+1);
        	
        	if(valid(map)) res = i+1;
        	
        }
        
        return res;
    }
	
	private boolean valid(HashMap<Integer, Integer> map) {
		if(map.size() > 2) return false;
		if(map.size() == 0) return false;
		else if(map.size() == 1) {
			int n = 0;
			for(int i : map.keySet()) 
				n = i;
			if(n == 1 || map.get(n) == 1) return true;
			else {
				return false;
			}
		} else {
			int a = 0;
			int b = 0;
			
			for(int i : map.keySet()) {
				if(a == 0) a = i;
				else b = i;
			}
			
			if((a == 1 && map.get(a) == 1) || (b == 1 && map.get(b) == 1)) return true;
			if(Math.abs(a-b) == 1) {
				if(a > b && map.get(a) == 1) return true;
				else if(b > a && map.get(b) == 1) return true;
				else return false;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		MaximumEqualFrequency test = new MaximumEqualFrequency();
		int[] nums = {1,1};
		System.out.println(test.maxEqualFreq(nums));
	}
	
}
