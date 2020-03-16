import java.util.HashMap;

public class MinimumScoreTriangulationofPolygon {

    public int minScoreTriangulationTLE(int[] A) {
        if(A.length == 3) return A[0] * A[1] * A[2];
        int min = Integer.MAX_VALUE;
        
        
        for(int i = 0; i < A.length; i++){
            int end = 0;
            if(i == 0) end = A.length-1;
            else end = A.length;
            for(int j = i + 2; j < end; j++){
                int p = A[i] * A[j];
                if(p < min) min = p;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            int end = 0;
            if(i == 0) end = A.length-1;
            else end = A.length;
            for(int j = i + 2; j < end; j++){
                int p = A[i] * A[j];
                if(p == min) {
                    int[] sub1 = new int[j-i+1];
                    System.arraycopy(A, i, sub1, 0, sub1.length);

                    int[] sub2 = new int[A.length-sub1.length + 2];
                    System.arraycopy(A, 0, sub2, 0, i+1);
                    System.arraycopy(A, j, sub2, i+1, sub2.length-i-1);

                    int aux = minScoreTriangulationTLE(sub1) + minScoreTriangulationTLE(sub2);
                    if(aux < res) res = aux;
                    
                }
            }
        }
        
        return res;
    }

    public int minScoreTriangulationTLE2(int[] A) {
        HashMap<String, Integer> memo = new HashMap<>();
        int res = helper(A, memo);
        return res;
    }

    private int helper(int[] A, HashMap<String, Integer> memo){
        StringBuilder sb = new StringBuilder();
        for(int i : A) sb.append(i + ",");
        String encode = sb.toString();
        if(memo.containsKey(encode)) return memo.get(encode);
        else{
            if(A.length == 3){
                int res = A[0] * A[1] * A[2];
                memo.put(encode, res);
                return res;
            }else{
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < A.length; i++){
                    int end = 0;
                    if(i == 0) end = A.length-1;
                    else end = A.length;
                    for(int j = i + 2; j < end; j++){
                        int[] sub1 = new int[j-i+1];
                        System.arraycopy(A, i, sub1, 0, sub1.length);
                        int[] sub2 = new int[A.length-sub1.length + 2];
                        System.arraycopy(A, 0, sub2, 0, i+1);
                        System.arraycopy(A, j, sub2, i+1, sub2.length-i-1);
                        int aux = helper(sub1, memo) + helper(sub2, memo);
                        if(aux < min) min = aux;
                    }
                }
                memo.put(encode, min);
                return min;
            }
        }
    }

    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int [][] dp = new int[n][n];

        for(int d = 2; d < n; d++){
            for(int i = 0; i + d < n; i++){
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        MinimumScoreTriangulationofPolygon test = new MinimumScoreTriangulationofPolygon();
        System.out.println(test.minScoreTriangulation(new int[] {35,73,90,27,71,80,21,33,33,13,48,12,68,70,80,36,66,3,70,58}));
        
    }

}