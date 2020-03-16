
public class MedianofTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sum = nums1.length + nums2.length;
        int[] merged = new int[sum];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        while(idx1 < nums1.length || idx2 < nums2.length) {
        	if(idx1 < nums1.length && idx2 < nums2.length) {
        		if(nums1[idx1] < nums2[idx2]) {
        			merged[idx++] = nums1[idx1++];
        		}else {
        			merged[idx++] = nums2[idx2++];
        		}
        	}else if(idx1 < nums1.length) {
        		merged[idx++] = nums1[idx1++];
        	}else if(idx2 < nums2.length) {
        		merged[idx++] = nums2[idx2++];
        	}
        }
        double res = 0;
        if(sum % 2 == 0) {
        	res = (double)(merged[sum/2] + merged[sum/2-1]) / 2;
        }else {
        	res = merged[sum/2];
        }
        return res;
    }
	
}
