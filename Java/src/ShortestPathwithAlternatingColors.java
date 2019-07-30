import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPathwithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        ArrayList<Integer>[] rg = new ArrayList[n];
        ArrayList<Integer>[] bg = new ArrayList[n];

        for(int i = 0; i < n; i++){
            rg[i] = new ArrayList<>();
            bg[i] = new ArrayList<>();
        }

        for(int[] edge : red_edges) rg[edge[0]].add(edge[1]);
        for(int[] edge : blue_edges) bg[edge[0]].add(edge[1]);

        int[] visitedBlue = new int[n];
        int[] visitedRed = new int[n];
        Arrays.fill(visitedBlue, Integer.MAX_VALUE);
        Arrays.fill(visitedRed, Integer.MAX_VALUE);


        dfs(0, true, visitedBlue, visitedRed, rg, bg, 0);
        dfs(0, false, visitedBlue, visitedRed, rg, bg, 0);

        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = Math.min(visitedBlue[i], visitedRed[i]);
            if(res[i] == Integer.MAX_VALUE) res[i] = -1;
        }

        return res;
    }

    private void dfs(int i, boolean fromBlue, int[] visitedBlue, int[] visitedRed, ArrayList<Integer>[] rg, ArrayList<Integer>[] bg, int count){
        if(fromBlue && count >= visitedBlue[i]) return;
        if(!fromBlue && count >= visitedRed[i]) return;

        if(fromBlue) visitedBlue[i] = count;
        else visitedRed[i] = count;

        if(fromBlue){
            for(int adj : rg[i]){
                dfs(adj, !fromBlue, visitedBlue, visitedRed, rg, bg, count+1);
            }
        }else{
            for(int adj : bg[i]){
                dfs(adj, !fromBlue, visitedBlue, visitedRed, rg, bg, count+1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] red_edges = {{0,1}, {0,2}};
        int[][] blue_edges = {{1,0}};
        ShortestPathwithAlternatingColors test = new ShortestPathwithAlternatingColors();
        int[] res = test.shortestAlternatingPaths(n, red_edges, blue_edges);
        for(int i : res) System.out.print(i + ",");
    }

}