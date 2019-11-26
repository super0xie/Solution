import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
	
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		
		int[] arr = new int[m * n];
		int idx = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[idx++] = grid[i][j];
			}
		}
		
		k = k % (m * n);
		if(k != 0)
			k = m * n - k;
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		int count = 0;
		
		for(; count < m * n; k++, k = k % (m * n),count++) {
			res.get(res.size()-1).add(arr[k]);
			if(res.get(res.size()-1).size() == n) res.add(new ArrayList<>());
		}
		
		res.remove(res.size()-1);
		return res;
    }
	
	public static void main(String[] args) {
		Shift2DGrid test = new Shift2DGrid();
		int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
		List<List<Integer>> res = test.shiftGrid(grid, 16);
		for(List<Integer> l : res) {
			for(int i : l)
				System.out.print(i + ", ");
			System.out.print("\n");
		}
		
	}
}
