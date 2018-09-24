
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if(grid.length == 0) return 0;
		int[][] aux = new int[grid.length][grid[0].length];
		int res = 0;
        for(int i = 0; i < grid.length; i++) {
        	int sum = 0;
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 'E') sum++;
        		else if(grid[i][j] == 'W') sum = 0;
        		else aux[i][j] = sum;
        	}
        	sum = 0;
        	for(int j = grid[0].length-1; j >= 0; j--) {
        		if(grid[i][j] == 'E') sum++;
        		else if(grid[i][j] == 'W') sum = 0;
        		else aux[i][j] += sum;
        	}
        }
        
        
        for(int j = 0; j < grid[0].length; j++) {
        	int sum = 0;
        	for(int i = 0; i < grid.length; i++) {
        		if(grid[i][j] == 'E') sum++;
        		else if(grid[i][j] == 'W') sum = 0;
        		else aux[i][j] += sum;
        	}
        	
        	sum = 0;
        	for(int i = grid.length-1; i >= 0; i--) {
        		if(grid[i][j] == 'E') sum++;
        		else if(grid[i][j] == 'W') sum = 0;
        		else {
        			aux[i][j] += sum;
        			res = Math.max(res, aux[i][j]);
        		}
        	}
        }
        
        return res;
    }

}
