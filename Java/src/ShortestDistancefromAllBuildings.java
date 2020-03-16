import java.util.LinkedList;

public class ShortestDistancefromAllBuildings{

    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;

    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] res = new int[m][n];
        int[][] reachable = new int[m][n];

        int srcCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    srcCount++;
                    bfs(grid, i, j, res, reachable);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && reachable[i][j] == srcCount) ret = Math.min(ret, res[i][j]);
            }
        }
        if(ret == Integer.MAX_VALUE) return -1;
        return ret;
    }

    private void bfs(int[][] grid, int r, int c, int[][] res, int[][] reachable){
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int [] {r, c});
        visited[r][c] = true;
        int dis = 1;
        while(!q.isEmpty()){
            LinkedList<int[]> aux = new LinkedList<>();
            while(!q.isEmpty()){
                int[] polled = q.poll();

                for(int k = 0; k < 4; k++){
                    int i = polled[0] + adj[k][0];
                    int j = polled[1] + adj[k][1];

                    if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && grid[i][j] == 0){
                        aux.add(new int [] {i, j});
                        visited[i][j] = true;
                        reachable[i][j]++;
                        res[i][j] += dis;
                    }
                }

            }
            dis++;
            q = aux;
        }
    }

    public static void main(String[] args) {
        ShortestDistancefromAllBuildings test = new ShortestDistancefromAllBuildings();
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(test.shortestDistance(grid));
    }

}