
public class MaximumSubarraySumwithOneDeletion {
	
	public int maximumSum(int[] arr) {
        int[] adp = new int[arr.length];
        int[] bdp = new int[arr.length];
        
        adp[0] = arr[0];
        bdp[0] = Integer.MIN_VALUE / 2;
        
        int res = Math.max(adp[0], bdp[0]);
        
        for(int i = 1; i < arr.length; i++) {
        	adp[i] = Math.max(arr[i], adp[i-1]+arr[i]);
        	bdp[i] = Math.max(adp[i-1], bdp[i-1]+arr[i]);
        	
        	res = Math.max(res, Math.max(adp[i], bdp[i]));
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumSubarraySumwithOneDeletion test = new MaximumSubarraySumwithOneDeletion();
		int[] arr = {-1,-1,-1,-1};
		System.out.println(test.maximumSum(arr));
	}
	
}
