import java.util.ArrayList;

public class DecompressRunLengthEncodedList {
	
	public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i+=2) {
        	int a = nums[i];
        	int b = nums[i+1];
        	
        	
        	for(int j = 0; j < a; j++) {
        		l.add(b);
        	}
        	
        }
        
        
        int[] res = new int[l.size()];
        for(int i = 0; i < l.size(); i++) {
        	res[i] = l.get(i);
        }
        
        return res;
    }
	
	
	
}
