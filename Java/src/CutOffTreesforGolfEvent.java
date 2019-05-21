import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class CutOffTreesforGolfEvent {

    public int cutOffTree(int[][] forest) {
        m = forest.length;
        n = forest[0].length;

        int[][] grid = new int[m][n];
        ArrayList<int[]> trees = new ArrayList<int[]>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = forest[i][j];
                if(grid[i][j] > 1) trees.add(new int[]{i, j});
            }
        }

        Collections.sort(trees, (a, b)->{
            return grid[a[0]][a[1]] - grid[b[0]][b[1]];
        });

        int res = 0;
        int[] cur = {0, 0};

        for(int i = 0; i < trees.size(); i++){
            int ret = helper(grid, cur, trees.get(i));
            if(ret < 0) return -1;
            res += ret;
            cur = trees.get(i);
        }

        return res;
    }


    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();

        int[][] grid = new int[m][n];
        ArrayList<int[]> trees = new ArrayList<int[]>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = forest.get(i).get(j);
                if(grid[i][j] > 1) trees.add(new int[]{i, j});
            }
        }

        Collections.sort(trees, (a, b)->{
            return grid[a[0]][a[1]] - grid[b[0]][b[1]];
        });

        int res = 0;
        int[] cur = {0, 0};

        for(int i = 0; i < trees.size(); i++){
            int ret = helper(grid, cur, trees.get(i));
            if(ret < 0) return -1;
            res += ret;
            cur = trees.get(i);
        }

        return res;
    }

    

    private int helper(int[][] grid, int[] src, int[] dst){
        if(src[0] == dst[0] && src[1] == dst[1]) return 0;

        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(src);
        visited[src[0]][src[1]] = true;
        int dis = 1;
        while(!queue.isEmpty()){
            LinkedList<int[]> aux = new LinkedList<>();

            while(!queue.isEmpty()){
                int[] l = queue.poll();
                int i = l[0];
                int j = l[1];

                for(int k = 0; k < 4; k++){
                    int r = i + adj[k][0];
                    int c = j + adj[k][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] != 0){
                        visited[r][c] = true;
                        if(r == dst[0] && c == dst[1]) return dis;
                        aux.add(new int[] {r, c});
                    }
                }
            }

            dis++;
            queue = aux;
        }

        return -1;
    }

    public static void main(String[] args) {
        CutOffTreesforGolfEvent test = new CutOffTreesforGolfEvent();
        int[][] forest = {{1,2,3}, {0,0,4}, {7,6,5}};
        System.out.println(test.cutOffTree(forest));
    }

}