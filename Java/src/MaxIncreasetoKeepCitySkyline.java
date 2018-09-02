
public class MaxIncreasetoKeepCitySkyline {
	
	public int maxIncreaseKeepingSkyline(int[][] grid) {
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
	
}
