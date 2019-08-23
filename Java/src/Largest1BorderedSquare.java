public class Largest1BorderedSquare{

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];

        for(int i = 0; i < m; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) count++;
                else count = 0;
                left[i][j] = count;
            }
            count = 0;
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 1) count++;
                else count = 0;
                right[i][j] = count;
            }
        }

        for(int j = 0; j < n; j++){
            int count = 0;
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1) count++;
                else count = 0;
                up[i][j] = count;
            }

            count = 0;
            for(int i = m-1; i >= 0; i--){
                if(grid[i][j] == 1) count++;
                else count = 0;
                down[i][j] = count;
            }
        }

        for(int k = Math.min(m, n); k >= 1; k--){
            for(int i = 0; i + k - 1 < m; i++){
                for(int j = 0; j + k - 1 <n; j++){
                    if(right[i][j] >= k && down[i][j] >= k && up[i+k-1][j+k-1] >= k && left[i+k-1][j+k-1] >= k){
                        return k * k;
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Largest1BorderedSquare test = new Largest1BorderedSquare();
        int[][] grid = {{1,1,0,0}};
        System.out.print(test.largest1BorderedSquare(grid));
    }

}