import java.util.HashMap;

public class CampusBikesII {

    private int m;
    private int n;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[][] d = new int[workers.length][bikes.length];
        m = workers.length;
        n = bikes.length;
        for(int i = 0; i < workers.length; i++)
            for(int j = 0; j < bikes.length; j++)
                d[i][j] = Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);

        return dfs(0, new boolean[n], d, new HashMap<>());
    }

    private int dfs(int i, boolean[] bikeUsed, int[][] d, HashMap<Integer, Integer> cache){
        int encode = 0;
        for(boolean b : bikeUsed){
            if(b) encode += 1;
            encode = encode << 1;
        }

        if(cache.containsKey(encode)) return cache.get(encode);

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            if(bikeUsed[j]) continue;
            bikeUsed[j] = true;
            if(i == m-1)
                res = Math.min(res, d[i][j]);
            else
                res = Math.min(res, d[i][j] + dfs(i+1, bikeUsed, d, cache));
            bikeUsed[j] = false;
        }

        cache.put(encode, res);
        return res;
    }

    public static void main(String[] args) {
        CampusBikesII test = new CampusBikesII();
        int[][] workers = {{0,0},{1,1},{2,0}};
        int[][] bikes = {{1,0},{2,2},{2,1}};
        System.out.println(test.assignBikes(workers, bikes));
    }

}