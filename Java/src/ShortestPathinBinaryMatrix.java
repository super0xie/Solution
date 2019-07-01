import java.util.LinkedList;

public class ShortestPathinBinaryMatrix{

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return 1;
        boolean[][] visited = new boolean[m][n];
        int[][] adj = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int len = 2;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            LinkedList<int[]> aux = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] polled = queue.poll();
                for(int k = 0; k < adj.length; k++){
                    int r = polled[0] + adj[k][0];
                    int c = polled[1] + adj[k][1];

                    if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 0){
                        if(r == m-1 && c == n-1) return len;
                        visited[r][c] = true;
                        aux.add(new int[]{r, c});
                    }
                }
            }

            queue = aux;
            len++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestPathinBinaryMatrix test = new ShortestPathinBinaryMatrix();
        System.out.println(test.shortestPathBinaryMatrix(grid));
    }

}