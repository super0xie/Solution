import java.util.ArrayList;

public class FlowerPlantingWithNoAdjacent{

    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        ArrayList<Integer>[] g = new ArrayList[N+1];
        for(int i = 0; i < g.length; i++) g[i] = new ArrayList<>();

        for(int[] p : paths){
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        for(int i = 1; i <= N; i++) dfs(i, res, g);
        return res;
    }

    private void dfs(int i, int[] res, ArrayList<Integer>[] g){
        if(res[i-1] != 0) return;
        boolean[] color = new boolean[5];
        for(int adj : g[i]){
            color[res[adj-1]] = true;
        }

        for(int k = 1; k <= 4; k++){
            if(!color[k]) {
            	res[i-1] = k;
            	break;
            }
        }

        for(int adj : g[i]){
            dfs(adj, res, g);
        }
    }

    public static void main(String[] args) {
        FlowerPlantingWithNoAdjacent test = new FlowerPlantingWithNoAdjacent();
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        int[] res = test.gardenNoAdj(4, paths);
        for(int i : res) System.out.print(i + ",");
    }

}