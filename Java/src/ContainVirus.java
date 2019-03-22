import java.util.HashMap;
import java.util.HashSet;

public class ContainVirus {

    private int m;
    private int n;
    private int [][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int containVirus(int[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length; 
        while(true){
            boolean[][] visited = new boolean[m][n];
            HashSet<Integer> maxThreat = new HashSet<>();
            int maxWall = 0;
            HashSet<Integer> maxCell = null;
            HashMap<Integer, Integer> allThreated = new HashMap<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j] && grid[i][j] == 1){
                        // HashSet<Integer> wall = new HashSet<>();
                        HashSet<Integer> cell = new HashSet<>();
                        HashSet<Integer> threated = new HashSet<>();
                        int[] wall = new int[1];

                        dfs(grid, i, j, visited, wall, cell, threated);
                        for(int t : threated) {
                            allThreated.put(t, allThreated.getOrDefault(t, 0)+1);
                        }
                        if(threated.size() > maxThreat.size()){
                            maxThreat = threated;
                            maxWall = wall[0];
                            maxCell = cell;
                        }
                    }
                }
            }

            if(maxThreat.size() == 0) break;
            else{
                res += maxWall;
                for(int i : maxCell){
                    int c = i % 50;
                    int r = i / 50;
                    grid[r][c] = 2;
                }
                
                for(int i : maxThreat) {
                    allThreated.put(i, allThreated.get(i)-1);
                }

                for(int i : allThreated.keySet()){
                    if(allThreated.get(i) > 0){
                        int c = i % 50;
                        int r = i / 50;
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int[] wall, HashSet<Integer> cell, HashSet<Integer> threated){
        visited[i][j] = true;
        cell.add(50 * i + j);

        for(int idx = 0; idx < adj.length; idx++){
            int r = i + adj[idx][0];
            int c = j + adj[idx][1];
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(grid[r][c] == 1 && !visited[r][c]){
                    dfs(grid, r, c, visited, wall, cell, threated);
                } else if(grid[r][c] == 0) {
                    threated.add(50 * r + c);
                    wall[0]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0,0,0,0,0,0},{1,0,1,0,1,1,1,1,1},{1,1,1,0,0,0,0,0,0}};
        ContainVirus test = new ContainVirus();
        System.out.println(test.containVirus(grid));
    }

}