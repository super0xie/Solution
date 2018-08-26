
public class SurfaceAreaof3DShapes {
	
    public int surfaceArea(int[][] grid) {
        int result = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] != 0) {
        			result += 2;
        		}
        		
        		result += grid[i][j] * 4;
        		
        		
        		if(i != 0) {
        			result -= Math.min(grid[i-1][j], grid[i][j]);
        		}
        		
        		if(i != grid.length-1) {
        			result -= Math.min(grid[i+1][j], grid[i][j]);
        		}
        		
        		if(j != 0) {
        			result -= Math.min(grid[i][j], grid[i][j-1]);
        		}
        		
        		if(j != grid[0].length-1) {
        			result -= Math.min(grid[i][j], grid[i][j+1]);
        		}
        		
        	}
        }
        
        
        
        return result;
    }
    
    public static void main(String[] args) {
    	
    	SurfaceAreaof3DShapes test = new SurfaceAreaof3DShapes();
    	int[][] grid = {{1,2}, {3,4}};
    	System.out.println(test.surfaceArea(grid));
    			
    }

}
