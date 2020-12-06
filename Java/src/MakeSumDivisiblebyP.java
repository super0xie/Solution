import java.util.Arrays;
import java.util.HashMap;

public class MakeSumDivisiblebyP {
	public int minSubarray(int[] nums, int p) {
		if(p < 100000) return minSubarraya(nums, p);
		else return minSubarrayb(nums, p);
	}
	public int minSubarraya(int[] nums, int p) {
        long sum = 0;
        for(int i : nums) sum += i;
        int mod = (int)(sum % p);
        if(mod == 0) return 0;
        
        int[] arr = new int [p];
        Arrays.fill(arr, -2);
        arr[0] = -1;
        long prefix = 0;
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
        	prefix += nums[i];
        	int m = (int)(prefix % p);
        	int target = m - mod;
        	if(target < 0) target += p;
        	if(arr[target] != -2) {
        		res = Math.min(res, i-arr[target]);
        	}
        	
        	arr[m] = i;
        }
        
        if(res == Integer.MAX_VALUE || res == nums.length) return -1;
        return res;
    }
	
	public int minSubarrayb(int[] nums, int p) {
        long sum = 0;
        for(int i : nums) sum += i;
        int mod = (int)(sum % p);
        if(mod == 0) return 0;
       
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefix = 0;
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
        	prefix += nums[i];
        	int m = (int)(prefix % p);
        	int target = m - mod;
        	if(target < 0) target += p;
        	if(map.containsKey(target)) res = Math.min(res, i-map.get(target));
        	map.put(m, i);
        }
        
        if(res == Integer.MAX_VALUE || res == nums.length) return -1;
        return res;
    }
	
	public static void main(String[] args) {
		MakeSumDivisiblebyP test = new MakeSumDivisiblebyP();
		int[] nums = {1,2,3};
		System.out.print(test.minSubarray(nums, 7));
	}
	
}

