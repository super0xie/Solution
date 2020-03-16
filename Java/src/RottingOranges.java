import java.util.LinkedList;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minute = 1;
        while(!queue.isEmpty()){
            LinkedList<int[]> aux = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] polled = queue.poll();

                for(int i = 0; i < adj.length; i++){
                    int r = polled[0] + adj[i][0];
                    int c = polled[1] + adj[i][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        res = Math.max(res, minute);
                        aux.add(new int[] {r, c});
                    }
                }
            }

            queue = aux;
            minute++;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges test = new RottingOranges();
        System.out.print(test.orangesRotting(grid));
    }

}