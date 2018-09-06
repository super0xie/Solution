import java.util.Arrays;

public class NextGreaterElementI {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Integer[] ind1 = new Integer[nums1.length];
        Integer[] ind2 = new Integer[nums2.length];
        
        for(int i = 0; i < ind1.length; i++) {
            ind1[i] = i;
        }
        
        for(int i = 0; i < ind2.length; i++) {
            ind2[i] = i;
        }
        
        Arrays.sort(ind1, (a,b)->{return nums1[a]-nums1[b];});
        Arrays.sort(ind2, (a,b)->{return nums2[a]-nums2[b];});
        
        int ind = 0;
        int [] res = new int[nums1.length];
        for(int i = 0; i < ind1.length; i++) {
            while(nums1[ind1[i]] != nums2[ind2[ind]]) {
                ind++;
            }
            int j = 0;
            for(j = ind2[ind]; j < nums2.length; j++) {
                if(nums2[j] > nums2[ind2[ind]]) break;
            }
            
            if(j == nums2.length) res[ind1[i]] = -1;
            else res[ind1[i]] = nums2[j];
            
            
        }
        
        return res;
        
    }
    
    public static void main(String[] args) {
        
        NextGreaterElementI test = new NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        test.nextGreaterElement(nums1, nums2);
    }

}
