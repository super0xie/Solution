import java.util.ArrayList;
import java.util.HashMap;

public class SplitArraywithEqualSum {
	
	public boolean splitArray(int[] nums) {
		if(nums.length < 7) return false;
        int[] lrPre = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	lrPre[i] = sum;
        	sum += nums[i];
        }
        
        HashMap<Integer, ArrayList<Integer>> rlMap = new HashMap<>();
        sum = 0;
        for(int i = nums.length-1; i >= 0; i--) {
        	sum += nums[i];
        	if(!rlMap.containsKey(sum)) rlMap.put(sum, new ArrayList<>());
        	rlMap.get(sum).add(i);
        }
        
        for(int i = 1; i < nums.length-5; i++) {
        	sum = lrPre[i];
        	if(!rlMap.containsKey(sum)) continue;
        	
        	ArrayList<Integer> l = rlMap.get(sum);
        	
        	for(int k : l) {
        		k = k-1;
        		if(k < i + 4) continue;
        		
        		for(int j = i + 2; j <= k-2; j++) {
        			int sumij = lrPre[j] - lrPre[i+1];
        			int sumjk = lrPre[k] - lrPre[j+1];
        			if(sumij == sumjk && sumij == sum) return true;
        		}
        	}
        }
        
        return false;
        
    }
	
	public static void main(String[] args) {
		SplitArraywithEqualSum test = new SplitArraywithEqualSum();
		int[] nums = {1,2,1,2,1,2,1};
		System.out.println(test.splitArray(nums));
	}
	
}
