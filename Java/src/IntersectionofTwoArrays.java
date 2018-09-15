import java.util.HashSet;

public class IntersectionofTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(int num : nums1) set1.add(num);
        
        HashSet<Integer> res = new HashSet<Integer>();
        for(int num : nums2) {
        	if(set1.contains(num)) res.add(num);
        }
        
        int [] ret = new int [res.size()];
        int idx = 0;
        
        for(int num : res) {
        	ret[idx++] = num;
        }
        
        return ret;
    }
	
}
