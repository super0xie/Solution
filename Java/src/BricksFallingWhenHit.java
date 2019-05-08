import java.util.HashSet;

public class BricksFallingWhenHit {
    
    public int[] hitBricksTLE(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];

        for(int idx = 0; idx < hits.length; idx++){
            if(grid[hits[idx][0]][hits[idx][1]] == 1){
                grid[hits[idx][0]][hits[idx][1]] = 0;
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                for(int j = 0; j < grid[0].length; j++){
                    if(!visited[0][j] && grid[0][j] == 1) {
                        dfs(grid, 0, j, visited);
                    }
                }
                int count = 0;
                for(int i = 0; i < grid.length; i++) {
                    for(int j = 0; j < grid[0].length; j++) {
                        if(grid[i][j] == 1 && !visited[i][j]) {
                            count++;
                            grid[i][j] = 0;
                        }
                    }
                }

                res[idx] = count;
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        for(int k = 0; k < 4; k++){
            int r = i + adj[k][0];
            int c = j + adj[k][1];
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]){
                dfs(grid, r, c, visited);
            }
        }
    }









    private int [][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        m = grid.length;
        n = grid[0].length;
        int[][] g = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                g[i][j] = grid[i][j];
            }
        }

        for(int[] hit : hits){
            g[hit[0]][hit[1]] = 0;
        }

        int[] uf = new int[m * n];
        int[] sz = new int[m * n];
        for(int i = 0; i < uf.length; i++) uf[i] = i;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(g[i][j] == 1) sz[getIdx(i, j)] = 1;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(g[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        int r = i + adj[k][0];
                        int c = j + adj[k][1];
                        if(r >= 0 && r < m && c >= 0 && c < n && g[r][c] == 1){
                            union(uf, sz, getIdx(i, j), getIdx(r, c));
                        }
                    }
                }
            }
        }

        int savedCount = getCount(uf, sz);
        for(int idx = hits.length-1; idx >= 0; idx--){
            int i = hits[idx][0];
            int j = hits[idx][1];
            if(grid[i][j] == 1){
                g[i][j] = 1;
                sz[getIdx(i, j)] = 1;

                for(int k = 0; k < 4; k++){
                    int r = i + adj[k][0];
                    int c = j + adj[k][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && g[r][c] == 1){
                        union(uf, sz, getIdx(i, j), getIdx(r, c));
                    }
                }

                int newCount = getCount(uf, sz);
                
                if(newCount > savedCount)
                    res[idx] = newCount - savedCount - 1;

                savedCount = newCount;
            }
        }

        return res;
    }

    private int getCount(int[] uf, int[] sz){
        HashSet<Integer> visited = new HashSet<>();
        int res = 0;
        for(int j = 0; j < n; j++){
            int root = getRoot(uf, j);
            if(!visited.contains(root)) {
                res += sz[root];
                visited.add(root);
            }
        }
        return res;
    }



    private int getIdx(int i, int j){
        return i * n + j;
    }

    private int getRoot(int[] uf, int i){
        if(uf[i] == i) return i;
        else{
            int res = getRoot(uf, uf[i]);
            uf[i] = res;
            return res;
        }
    }

    private void union(int[] uf, int[] sz, int i, int j){
        int r1 = getRoot(uf, i);
        int r2 = getRoot(uf, j);
        if(r1 != r2){
            uf[r1] = r2;
            sz[r2] += sz[r1];
        }
    }

    

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{1,1,0,0}};
        int[][] hits = {{1,1}, {1,0}};
        BricksFallingWhenHit test = new BricksFallingWhenHit();
        int[] res = test.hitBricks(grid, hits);
        for(int i : res){
            System.out.println(i);
        }
    }

}