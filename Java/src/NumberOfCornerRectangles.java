import java.util.HashMap;

public class NumberOfCornerRectangles {
	
	public int countCornerRectanglesOld(int[][] grid) {
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i = 0; i < grid[0].length; i++) {
        	if(grid[0][i] == 1) {
        		for(int j = i+1; j < grid[0].length; j++) {
        			if(grid[0][j] == 1) set.put(200 * i + j, 1);
        		}
        	}
        }
        
        for(int r = 1; r < grid.length; r++) {
        	for(int i = 0; i < grid[0].length; i++) {
            	if(grid[r][i] == 1) {
            		for(int j = i+1; j < grid[0].length; j++) {
            			if(grid[r][j] == 1) {
            				if(set.containsKey(200 * i + j)) {
            					res+= set.get(200 * i + j);
            					set.put(200 * i + j, set.get(200 * i + j)+1);
            				}
            				else set.put(200*i + j, 1);
            			}
            		}
            	}
            }
        }
        return res;
	}
	
	public int countCornerRectangles(int[][] grid) {
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        int res = 0;
        
        for(int r = 0; r < grid.length; r++) {
        	for(int i = 0; i < grid[0].length; i++) {
            	if(grid[r][i] == 1) {
            		for(int j = i+1; j < grid[0].length; j++) {
            			if(grid[r][j] == 1) {
            				if(set.containsKey(200 * i + j)) {
            					res+= set.get(200 * i + j);
            					set.put(200 * i + j, set.get(200 * i + j)+1);
            				}
            				else set.put(200*i + j, 1);
            			}
            		}
            	}
            }
        }
        return res;
    }

}
