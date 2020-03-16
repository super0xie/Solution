import java.util.ArrayList;
import java.util.HashMap;

public class MakingALargeIsland {

    public int largestIslandUF(int[][] grid) {
        int n = grid.length;
        int[] uf = new int[n * n];
        for(int i = 0; i < uf.length; i++){
            uf[i] = i;
        }

        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                int idx = i * n + j;

                for(int k = 0; k < 4; k++){
                    int r = i + adj[k][0];
                    int c = j + adj[k][1];

                    if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                        union(uf, idx, r * n + c);
                    }
                }
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int key = root(uf, i*n+j);
                    int value = map.getOrDefault(key, 0)+1;
                    res = Math.max(res, value);
                    map.put(key, value);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int sum = 1;
                    ArrayList<Integer> keys = new ArrayList<Integer>();
                    for(int k = 0; k < 4; k++){
                        int r = i + adj[k][0];
                        int c = j + adj[k][1];

                        if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                            int key = root(uf, r*n+c);
                            if(!keys.contains(key)){
                                sum += map.get(key);
                                keys.add(key);
                            }
                        }
                    }
                    res = Math.max(res, sum);
                }
            }
        }

        return res;
    }

    private int root(int[] uf, int i){
        if(uf[i] == i) return i;
        else{
            int r = root(uf, uf[i]);
            uf[i] = r;
            return r;
        }
    }

    private void union(int[] uf, int i, int j){
        int r1 = root(uf, i);
        int r2 = root(uf, j);

        if(r1 != r2){
            uf[r1] = r2;
        }
    }



    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int n;
    public int largestIsland(int[][] grid) {
        int res = 0;
        n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();


        int idx = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int[] count = new int[1];
                    dfs(grid, i, j, idx, count);
                    res = Math.max(res, count[0]);
                    map.put(idx, count[0]);
                    idx++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int sum = 1;
                    int[] keys = new int[4];
                    for(int k = 0; k < 4; k++){
                        int r = i + adj[k][0];
                        int c = j + adj[k][1];

                        if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] != 0){
                            int key = grid[r][c];
                            int l = 0;
                            for(; l < 4; l++){
                                if(keys[l] == key) break;
                            }
                            if(l == 4){
                                sum += map.get(key);
                                keys[k] = key;
                            }
                        }
                    }
                    res = Math.max(res, sum);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int key, int[] count){
        count[0]++;
        grid[i][j] = key;

        for(int k = 0; k < 4; k++){
            int r = i + adj[k][0];
            int c = j + adj[k][1];
            if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                dfs(grid, r, c, key, count);
            }
        }
    } 

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
        MakingALargeIsland test = new MakingALargeIsland();
        System.out.println(test.largestIsland(grid));
    }

}