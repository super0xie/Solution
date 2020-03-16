import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NumberofDistinctIslandsII {

    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;
    public int numDistinctIslands2(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ArrayList<int[]> l = new ArrayList<>();
                    dfs(grid, i, j, l);
                    String encode = encode(l);
                    if(!set.contains(encode)){
                        res++;
                        set.add(encode);
                        ArrayList<String> trans = trans(l);
                        for(String str : trans) set.add(str);
                        for(int [] p : l){
                            p[1] = n-1-p[1];
                        }
                        set.add(encode(l));
                        trans = trans(l);
                        for(String str : trans) set.add(str);
                    }
                }
            }
        }

        return res;
    }

    private ArrayList<String> trans(ArrayList<int[]> l){
        ArrayList<String> res = new ArrayList<>();

        //90
        ArrayList<int[]> points = new ArrayList<>();
        for(int[] p: l){
            points.add(new int[] {m-1-p[1], p[0]});
        }
        res.add(encode(points));

        //180
        points = new ArrayList<>();
        for(int[] p: l){
            points.add(new int[] {m-1-p[0], n-1-p[1]});
        }
        res.add(encode(points));

        //-90
        points = new ArrayList<>();
        for(int[] p: l){
            points.add(new int[] {p[1], n-1-p[0]});
        }
        res.add(encode(points));
        return res;
    }

    private void dfs(int[][] grid, int r, int c, ArrayList<int[]> list){
        grid[r][c] = 0;
        list.add(new int[] {r, c});

        for(int i = 0; i < adj.length; i++){
            int rr = r + adj[i][0];
            int cc = c + adj[i][1];

            if(rr >= 0 && rr < grid.length && cc >= 0 && cc < grid[0].length && grid[rr][cc] == 1){
                dfs(grid, rr, cc, list);
            }
        }
    }

    private String encode(ArrayList<int[]> l){
        Collections.sort(l, (a, b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });

        int offR = l.get(0)[0];
        int offC = l.get(0)[1];
        StringBuilder sb = new StringBuilder();
        for(int[] p : l){
            sb.append(p[0]-offR);
            sb.append(",");
            sb.append(p[1]-offC);
            sb.append(",");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0,0,1,0,1,1,0,0,1,0,1,1},{1,1,0,1,1,1,0,0,1,0,1,0,0,0,1},{0,0,1,1,1,0,1,0,0,1,0,1,1,0,0},{1,1,1,1,1,1,0,0,0,0,0,1,1,1,0},{0,1,1,0,1,1,1,0,0,0,0,1,0,1,0},{1,0,0,0,0,0,1,1,0,1,1,1,1,0,0},{1,0,1,0,0,1,1,1,0,1,0,1,1,0,1},{0,0,0,1,0,0,1,1,1,1,0,1,0,0,1},{1,1,1,0,0,0,0,1,1,1,1,0,0,0,0},{1,1,0,0,0,0,0,0,0,1,0,0,0,1,0}};
        NumberofDistinctIslandsII test = new NumberofDistinctIslandsII();
        System.out.println(test.numDistinctIslands2(grid));
    }

}