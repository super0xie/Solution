
public class MaxIncreasetoKeepCitySkyline {
	
	public int maxIncreaseKeepingSkylineOld(int[][] grid) {
        int [] rowMax = new int [grid.length];
        int [] colMax = new int [grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
        	int max = Integer.MIN_VALUE;
        	for(int j = 0; j < grid[0].length; j++)
        		max = Math.max(max, grid[i][j]);
        	rowMax[i] = max;
        }
        
        
        for(int j = 0; j < grid[0].length; j++) {
        	int max = Integer.MIN_VALUE;
        	for(int i = 0; i < grid.length; i++)
        		max = Math.max(max, grid[i][j]);
        	colMax[j] = max;
        }
        
        int sum = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		int target = Math.min(rowMax[i], colMax[j]);
        		sum += target - grid[i][j];
        		
        	}
        }
        
        return sum;
        
	}
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] rowMax = new int[grid.length];
		int[] colMax = new int[grid[0].length];

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				rowMax[i] = Math.max(rowMax[i], grid[i][j]);
				colMax[j] = Math.max(colMax[j], grid[i][j]);
			}
		}
		int res = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				res += Math.min(rowMax[i], colMax[j]) - grid[i][j];
			}
		}

		return res;
    }
	
}
