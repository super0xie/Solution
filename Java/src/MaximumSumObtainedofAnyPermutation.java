import java.util.Arrays;

public class MaximumSumObtainedofAnyPermutation {
	
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int mod = 1000000000+7;
        int n = nums.length;
        int[] count = new int[n];
        for(int[] r : requests) {
        	count[r[0]]++;
        	if(r[1]+1 < n) count[r[1]+1]--;
        }
        
        int[] feq = new int[n];
        int cur = 0;
        for(int i = 0; i < n; i++) {
        	cur += count[i];
        	feq[i] = cur;
        }
        
        long sum = 0;
        
        Arrays.parallelSort(feq);
        Arrays.parallelSort(nums);
        
        for(int i = n-1; i >= 0; i--) {
        	if(feq[i] == 0) break;
        	sum += (long)feq[i] * nums[i];
        	sum %= mod;
        }
        
        return (int)sum;
    }
	
	public static void main(String[] args) {
		MaximumSumObtainedofAnyPermutation test = new MaximumSumObtainedofAnyPermutation();
		int[] nums = {1,2,3,4,5,10};
		int[][] requests = {{0,2},{1,3},{1,1}};
		test.maxSumRangeQuery(nums, requests);
	}
	
}
