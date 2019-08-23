import java.util.ArrayList;
import java.util.Arrays;

public class ParallelCourses {
    private boolean hasCycle = false;
    public int minimumSemesters(int N, int[][] relations) {
        ArrayList<Integer>[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList<>();
        for(int[] r : relations) g[r[0]].add(r[1]);

        int[] d = new int[N+1];
        boolean[] onStack = new boolean[N+1];
        Arrays.fill(d, -1);

        for(int i = 1; i <= N; i++){
            dfs(i, g, d, onStack);
        }
        if(hasCycle) return -1;
        int res = 0;
        for(int i : d) res = Math.max(res, i);
        return res;
    }

    private int dfs(int i, ArrayList<Integer>[] g, int[] d, boolean[] onStack){
        if(hasCycle) return -1;
        if(onStack[i]){
            hasCycle = true;
            return -1;
        }
        if(d[i] != -1) return d[i];

        onStack[i] = true;

        int res = 0;
        for(int adj : g[i]) res = Math.max(res, dfs(adj, g, d, onStack));
        res++;

        d[i] = res;

        onStack[i] = false;
        return res;
    }

}