import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    
    int[][][] maze;
    Random r;
    //                 up,     right, down,    left 
    int[][] neigh = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[] other = {2, 3, 0, 1};
    int m, n;
    public int[][][] generateMaze(int m, int n) {
        this.m = m;
        this.n = n;
        maze = new int[m][n][5];
        r = new Random();
        dfs(0, 0);
        return maze;
    }
    
    private void dfs(int i, int j) {
        maze[i][j][4] = 1;
        while(true) {
            List<Integer> nei = getUnvisitedNeighbor(i, j);
            if(nei.size() == 0) break;
            int idx = r.nextInt(nei.size());
            int dir = nei.get(idx);
            int r = i + neigh[dir][0];
            int c = j + neigh[dir][1];
            maze[i][j][dir] = 1;
            int otherDir = other[dir];
            maze[r][c][otherDir] = 1;
            
            dfs(r, c);
        }
    }
    
    private List<Integer> getUnvisitedNeighbor(int i, int j){
        List<Integer> ret = new ArrayList<Integer>();
        for(int k = 0; k < 4; k++) {
            int r = i + neigh[k][0];
            int c = j + neigh[k][1];
            
            if(r >= 0 && r < m && c >= 0 && c < n && maze[r][c][4] == 0) {
                ret.add(k);
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        MazeGenerator test = new MazeGenerator();
        test.generateMaze(3, 3);
    }

}
