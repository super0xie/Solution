import java.util.ArrayList;
import java.util.List;

public class Reconstructa2RowBinaryMatrix {
	
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		int n = colsum.length;
		List<List<Integer>> res = new ArrayList<>();
		int[][] arr = new int[2][n];
		
		for(int i = 0; i < n; i++) {
			if(colsum[i] == 2) {
				if(upper == 0 || lower == 0) return res;
				arr[0][i] = 1;
				arr[1][i] = 1;
				upper--;
				lower--;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(colsum[i] == 1) {
				if(upper > 0) {
					arr[0][i] = 1;
					upper--;
				}else {
					if(lower == 0) return res;
					arr[1][i] = 1;
					lower--;
				}
			}
		}
		
		if(upper != 0 || lower != 0) return res;
		
		List<Integer> r0 = new ArrayList<>();
		List<Integer> r1 = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			r0.add(arr[0][i]);
			r1.add(arr[1][i]);
		}
		
		res.add(r0);
		res.add(r1);
		return res;
    }
	
	public static void main(String[] args) {
		Reconstructa2RowBinaryMatrix test = new Reconstructa2RowBinaryMatrix();
		List<List<Integer>> res = test.reconstructMatrix(4, 7, new int[] {2,1,2,2,1,1,1});
//		for(int i : res) System.out.print(i + ", ");
	}
	
	
	
}
