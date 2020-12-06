import java.util.Arrays;

public class GettheMaximumScore {
	
	public int maxSum(int[] nums1, int[] nums2) {
        long res = 0;
        int last = 0;
        int mod = 1_000_000_000 + 7;
        for(int i = 0; i < nums1.length; i++) {
        	int bs = Arrays.binarySearch(nums2, nums1[i]);
        	if(bs < 0) continue;
        	
        	if(last == 0) {
        		long s1 = 0;
        		for(int j = 0; j < i; j++) s1 += nums1[j];
        		long s2 = 0;
        		for(int j = 0; j < bs; j++) s2 += nums2[j];
        		res += Math.max(s1, s2);
        		res += nums1[i];
        	} else {
        		long s1 = 0;
        		int start = Arrays.binarySearch(nums1, last);
        		for(int j = start+1; j < i; j++) s1 += nums1[j];
        		
        		long s2 = 0;
        		start = Arrays.binarySearch(nums2, last);
        		for(int j = start+1; j < bs; j++) s2 += nums2[j];
        		
        		res += Math.max(s1, s2);
        		res += nums1[i];
        	}
        	res = res % mod;
        	last = nums1[i];
        }
        
        
        if(last == 0) {
        	long s1 = 0;
        	long s2 = 0;
        	for(int i : nums1) s1 += i;
        	for(int i : nums2) s2 += i;
        	return (int)(Math.max(s1, s2) % mod);
        }else {
        	long s1 = 0;
    		int start = Arrays.binarySearch(nums1, last);
    		for(int j = start+1; j < nums1.length; j++) s1 += nums1[j];
    		long s2 = 0;
    		start = Arrays.binarySearch(nums2, last);
    		for(int j = start+1; j < nums2.length; j++) s2 += nums2[j];
    		
    		res += Math.max(s1, s2);
        	return (int)(res % mod);
        }
        
        
    }
	
	public static void main(String[] args) {
		GettheMaximumScore test = new GettheMaximumScore();
		int[] nums1 = {1,4,5,8,9,11,19};
		int[] nums2 = {2,3,4,11,12};
		System.out.print(test.maxSum(nums1, nums2));
	}
	
}
