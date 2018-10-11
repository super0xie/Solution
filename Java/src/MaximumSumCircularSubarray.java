
public class MaximumSumCircularSubarray {
	
	public int maxSubArray(int[] nums, int a, int b) {
		int[] adp = new int[b-a+1];
		int[] bdp = new int[b-a+1];
		
		adp[0] = nums[a];
		bdp[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i < adp.length; i++) {
			bdp[i] = Math.max(adp[i-1], bdp[i-1]);
			adp[i] = Math.max(nums[a+i], adp[i-1] + nums[a+i]);
		}
		
		return Math.max(adp[adp.length-1], bdp[adp.length-1]);
	}
	
	public int maxSubArray(int[] nums) {
		int[] adp = new int[nums.length];
		int[] bdp = new int[nums.length];
		
		adp[0] = nums[0];
		bdp[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i++) {
			bdp[i] = Math.max(adp[i-1], bdp[i-1]);
			adp[i] = Math.max(nums[i], adp[i-1] + nums[i]);
		}
		
		return Math.max(adp[nums.length-1], bdp[nums.length-1]);
	}
	
	public int maxSubarraySumCircular(int[] A) {
		int res = Integer.MIN_VALUE;
		res = Math.max(res, maxSubArray(A));
		if(A.length <= 2) return res;
		
		int[] left = new int[A.length];
		int sum = A[0];
		int maxSum = sum;
		for(int i = 1; i < A.length; i++) {
			left[i] = maxSum;
			sum += A[i];
			maxSum = Math.max(maxSum, sum);
		}
		
		int[] right = new int[A.length];
		sum = A[A.length - 1];
		maxSum = sum;
		for(int i = A.length-2; i >= 0; i--) {
			right[i] = maxSum;
			sum+= A[i];
			maxSum = Math.max(maxSum, sum);
		}
		
		for(int i = 1; i < A.length-1; i++) {
			res = Math.max(res, left[i] + right[i]);
		}
		return res;
		
	}
	
	public int maxSubarraySumCircularTLE(int[] A) {
        int[] aux = new int[A.length * 2];
        
        for(int i = 0 ; i < A.length; i++) {
        	aux[i] = A[i];
        	aux[i + A.length] = A[i];
        }
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < A.length; i++) {
        	if(aux[i] <= 0) res = Math.max(res, aux[i]);
        	else res = Math.max(res, maxSubArray(aux, i, i + A.length-1));
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumSumCircularSubarray test = new MaximumSumCircularSubarray();
		int[] A = {-2,-3,-1};
		System.out.println(test.maxSubarraySumCircular(A));
	}
}
