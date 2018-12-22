import java.util.ArrayList;
import java.util.Arrays;

public class LargestTimeforGivenDigits {
	
	private ArrayList<Integer> list = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        dfs(A, 0);
        
        for(ArrayList<Integer> l : res) {
        	if(valid(l)) {
        		return String.format("%d%d:%d%d", l.get(0), l.get(1), l.get(2), l.get(3));
        	}
        }
        
        return "";
    }
	
	private void dfs(int[] A, int c) {
		if(c == 4) res.add(new ArrayList<>(list));
		for(int i = 3; i >= 0; i--) {
			if(A[i] != Integer.MAX_VALUE) {
				int saved = A[i];
				list.add(A[i]);
				A[i] = Integer.MAX_VALUE;
				dfs(A, c+1);
				A[i] = saved;
				list.remove(list.size()-1);
			}
		}
	}
	
	private boolean valid(ArrayList<Integer> l) {
		int hr = l.get(0) * 10 + l.get(1);
		if(hr > 23 || hr < 0) return false;
		int mi = l.get(2) * 10 + l.get(3);
		if(mi > 59 || mi < 0) return false;
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		LargestTimeforGivenDigits test = new LargestTimeforGivenDigits();
		int[] A = {2,0,6,6};
		
		
		System.out.println(test.largestTimeFromDigits(A));
	}
	
}
