import java.util.HashMap;

public class NumberofEquivalentDominoPairs {

    public int numEquivDominoPairsOld(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < dominoes.length; i++){
            int encode = 0;

            if(dominoes[i][0] <= dominoes[i][1]) encode = 10 * dominoes[i][0] + dominoes[i][1];
            else encode = 10 * dominoes[i][1] + dominoes[i][0];

            if(map.containsKey(encode)) res += map.get(encode);

            map.put(encode, map.getOrDefault(encode, 0)+1);
        }

        return res;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        int res = 0;
        for(int i = 0; i < dominoes.length; i++){
            int encode = 0;

            if(dominoes[i][0] <= dominoes[i][1]) encode = 10 * dominoes[i][0] + dominoes[i][1];
            else encode = 10 * dominoes[i][1] + dominoes[i][0];

            res += map[encode];

            map[encode]++;
        }

        return res;
    }



}