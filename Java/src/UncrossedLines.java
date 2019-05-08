import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UncrossedLines {

    public int maxUncrossedLinesOld(int[] A, int[] B) {
        int res = 0;
        HashMap<Integer, Integer> [] dp = new HashMap[A.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            if(!map.containsKey(B[i])) map.put(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }

        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i])) continue;
            ArrayList<Integer> indice = map.get(A[i]);
            res = Math.max(res, 1);
            dp[i] = new HashMap<>();
            dp[i].put(1, indice.get(0));

            for(int j = 0; j < i; j++){
                if(dp[j] == null) continue;
                for(int key : dp[j].keySet()){
                    int idx = dp[j].get(key);
                    int rt = Collections.binarySearch(indice, idx);
                    int ip = 0;
                    if(rt >= 0) ip = rt+1;
                    else ip = -rt-1;

                    if(ip < indice.size()) {
                        int len = key + 1;
                        res = Math.max(res, len);
                        dp[i].put(len, Math.min(dp[i].getOrDefault(len, Integer.MAX_VALUE), indice.get(ip)));
                    }
                }

            }
        }

        return res;
    }



    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];

        boolean exist = false;
        for(int i = 0; i < A.length; i++){
            if(A[i] == B[0]) exist = true;
            dp[i][0] = exist ? 1 : 0;
        }

        exist = false;
        for(int j = 0; j < B.length; j++){
            if(A[0] == B[j]) exist = true;
            dp[0][j] = exist ? 1 : 0;
        }

        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < B.length; j++){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[A.length-1][B.length-1];
    }

    public static void main(String[] args) {
        int[] A = {2,5,1,2,5};
        int[] B = {10,5,2,1,5,2};
        UncrossedLines test = new UncrossedLines();
        System.out.println(test.maxUncrossedLines(A, B));
    }

}