import java.util.LinkedList;

public class AsFarfromLandasPossible {

    public int maxDistanceOld(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dis = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    LinkedList<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int d = 1;
                    while(!q.isEmpty()){
                        LinkedList<int[]> aux = new LinkedList<>();
                        while(!q.isEmpty()){
                            int[] polled = q.poll();
                            for(int k = 0; k < adj.length; k++){
                                int r = polled[0] + adj[k][0];
                                int c = polled[1] + adj[k][1];
                                if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && dis[r][c] > d){
                                    dis[r][c] = d;
                                    aux.add(new int[]{r, c});
                                }
                            }
                        }
                        d++;
                        q = aux;
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) res = Math.max(res, dis[i][j]);
            }
        }

        if(res == Integer.MIN_VALUE || res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int res = -1;
        LinkedList<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) q.add(new int[] {i, j});
            }
        }

        int d = 1;
        while(!q.isEmpty()){
            LinkedList<int[]> aux = new LinkedList<>();
            while(!q.isEmpty()){
                int[] polled = q.poll();
                for(int k = 0; k < adj.length; k++){
                    int r = polled[0] + adj[k][0];
                    int c = polled[1] + adj[k][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c]){
                        visited[r][c] = true;
                        res = d;
                        aux.add(new int[]{r, c});
                    }
                }
            }
            d++;
            q = aux;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        AsFarfromLandasPossible test = new AsFarfromLandasPossible();
        System.out.print(test.maxDistance(grid));
    }

}
