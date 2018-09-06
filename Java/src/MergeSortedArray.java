
public class MergeSortedArray {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index = nums1.length-1;
        for(int i = m-1; i >= 0; i--) {
            nums1[index--] = nums1[i];
        }
        
        int index1 = nums1.length-m;
        int index2 = 0;
        index = 0;
        
        while(index1 < nums1.length || index2 < nums2.length) {
            if(index1 >= nums1.length) {
                nums1[index++] = nums2[index2++];
            }else if(index2 >= nums2.length) {
                nums1[index++] = nums1[index1++];
            }else {
                if(nums1[index1] < nums2[index2]) {
                    nums1[index++] = nums1[index1++];
                }else {
                    nums1[index++] = nums2[index2++];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        MergeSortedArray test = new MergeSortedArray();
        test.merge(nums1, m, nums2, n);
    }

}
