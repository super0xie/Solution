import java.util.ArrayList;

public class CreateTargetArrayintheGivenOrder {
	
	public int[] createTargetArray(int[] nums, int[] index) {
		int n = index.length;
		ArrayList<Integer> l = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			l.add(index[i], nums[i]);
		}
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
        	res[i] = l.get(i);
        }
		
        return res;
    }
	
}
