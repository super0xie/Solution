import java.util.HashSet;

public class BitwiseORsofSubarrays {
	
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> prev = new HashSet<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++) {
        	HashSet<Integer> curr = new HashSet<Integer>();
        	for(int pre : prev) {
        		curr.add(pre | A[i]);
        	}
        	curr.add(A[i]);
        	set.addAll(curr);
        	prev = curr;
        }
        return set.size();
    }
    
    public static void main(String[] args) {
    	BitwiseORsofSubarrays test = new BitwiseORsofSubarrays();
    	int[] nums = {};
    	System.out.println(test.subarrayBitwiseORs(nums));
    }

}
