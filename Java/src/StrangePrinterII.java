import java.util.ArrayList;

public class StrangePrinterII {
	
	
	private int m;
	private int n;
	
	public boolean isPrintable(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		
		boolean[] colors = new boolean[61];
		int numOfColor = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!colors[grid[i][j]]) numOfColor++;
				colors[grid[i][j]] = true;
			}
		}
		
		while(numOfColor > 0) {
			int[][] range = new int[61][4];
			for(int i = 0; i < range.length; i++) {
				range[i][0] = Integer.MAX_VALUE;
				range[i][1] = Integer.MIN_VALUE;
				range[i][2] = Integer.MAX_VALUE;
				range[i][3] = Integer.MIN_VALUE;
			}
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(grid[i][j] == 0) continue;
					int c = grid[i][j];
					range[c][0] = Math.min(range[c][0], i);
					range[c][1] = Math.max(range[c][1], i);
					range[c][2] = Math.min(range[c][2], j);
					range[c][3] = Math.max(range[c][3], j);
				}
			}
			
			int saved = numOfColor;
			for(int i = 0; i < colors.length; i++) {
				if(colors[i]) {
					if(valid(grid, i, range[i])) {
						print(grid, i, range[i]);
						numOfColor--;
						colors[i] = false;
					}
				}
			}
			
			if(saved == numOfColor) return false;
		}
		
		return true;
    }
	
	private boolean valid(int[][] grid, int color, int[] range) {
		for(int i = range[0]; i <= range[1]; i++) {
			for(int j = range[2]; j <= range[3]; j++) {
				if(grid[i][j] == 0) continue;
				if(grid[i][j] != color && grid[i][j] != 0) return false;
			}
		}
		return true;
	}
	
	private void print(int[][] grid, int color, int[] range) {
		for(int i = range[0]; i <= range[1]; i++)
			for(int j = range[2]; j <= range[3]; j++) grid[i][j] = 0;
	}
	
	public static void main(String[] args) {
		StrangePrinterII test = new StrangePrinterII();
		int[][] grid = {{1,1,1},{3,1,3}};
		System.out.println(test.isPrintable(grid));
	}
	
}
