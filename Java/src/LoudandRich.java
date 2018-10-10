import java.util.ArrayList;
import java.util.Arrays;

public class LoudandRich {
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<Integer> [] graph = new ArrayList[quiet.length];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] pair : richer) {
            graph[pair[1]].add(pair[0]);
        }
        
        int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < res.length; i++) {
            res[i] = dfs(i, graph, res, quiet);
        }
        return res;
    }
    
    private int dfs(int i, ArrayList<Integer> [] graph, int[] mem, int[] quiet) {
        if(mem[i] >= 0) return mem[i];
        int res = i;
        for(int adj : graph[i]) {
            int ret = dfs(adj, graph, mem, quiet);
            if(ret != Integer.MAX_VALUE && quiet[ret] < quiet[res]) {
                res = ret;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        LoudandRich test = new LoudandRich();
        test.loudAndRich(richer, quiet);
    }
    
}
