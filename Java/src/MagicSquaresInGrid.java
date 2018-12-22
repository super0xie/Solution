
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length-2; i++) {
            for(int j = 0; j < grid[0].length-2; j++) {
                if(helper(grid, i, j)) res++;
            }
        }
        return res;
    }
    
    private boolean helper(int[][] grid, int r, int c) {
        boolean[] exist = new boolean[9];
        for(int i = r; i < r+3; i++) {
            int sum = 0;
            for(int j = c; j < c+3; j++) {
                int n = grid[i][j];
                sum += n;
                if(n < 1 || n > 9) return false;
                if(exist[n-1]) return false;
                exist[n-1] = true;
            }
            if(sum != 15) return false;
        }
        
        for(int j = c; j < c+3; j++) {
            int sum = 0;
            for(int i = r; i < r+3; i++) {
                sum += grid[i][j];
            }
            if(sum != 15) return false;
        }
        
        if(grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != 15) return false;
        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != 15) return false;
        return true;
    }

}
