import java.util.HashMap;
import java.util.HashSet;

public class GridIllumination {

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashSet<Long> l = new HashSet<>();
        HashMap<Integer, Integer> sum = new HashMap<>();
        HashMap<Integer, Integer> minus = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        long a = 1000000001;
        for(int[] lamp : lamps){
            long encode = lamp[0] * a + lamp[1];
            int s = lamp[0] + lamp[1];
            int m = lamp[0] - lamp[1];

            l.add(encode);
            sum.put(s, sum.getOrDefault(s, 0)+1);
            minus.put(m, minus.getOrDefault(m, 0)+1);
            row.put(lamp[0], row.getOrDefault(lamp[0], 0)+1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0)+1);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0] + queries[i][1];
            int m = queries[i][0] - queries[i][1];

            if(sum.containsKey(s) || minus.containsKey(m) || row.containsKey(queries[i][0]) || col.containsKey(queries[i][1])) res[i] = 1;

            for(int r = queries[i][0]-1; r <= queries[i][0]+1; r++){
                for(int c = queries[i][1]-1; c <= queries[i][1]+1; c++){
                    long encode = r * a + c;
                    if(l.contains(encode)){
                        s = r+c;
                        m = r-c;
                        if(sum.containsKey(s)){
                            if(sum.get(s) > 1) sum.put(s, sum.get(s)-1);
                            else sum.remove(s);
                        }

                        if(minus.containsKey(m)){
                            if(minus.get(m) > 1) minus.put(m, minus.get(m)-1);
                            else minus.remove(m);
                        }

                        if(row.containsKey(r)){
                            if(row.get(r) > 1) row.put(r, row.get(r)-1);
                            else row.remove(r);
                        }

                        if(col.containsKey(c)){
                            if(col.get(c) > 1) col.put(c, col.get(c)-1);
                            else col.remove(c);
                        }
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] lamps = {{0,0},{4,4}};
        int[][] queries = {{1,1},{1,0}};
        GridIllumination test = new GridIllumination();
        int[] res = test.gridIllumination(5, lamps, queries);
        for(int i : res){
            System.out.println(i);
        }


    }

}