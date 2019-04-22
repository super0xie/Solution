import java.util.HashMap;

public class LongestArithmeticSequence{

    public int longestArithSeqLength(int[] A) {
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int res = 1;
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int diff = A[i] - A[j];
                int len = 0;

                if(dp[j].containsKey(diff)) len = dp[j].get(diff) + 1;
                else len = 2;

                res = Math.max(res, len);
                if(!dp[i].containsKey(diff) || dp[i].get(diff) < len) dp[i].put(diff, len);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence test = new LongestArithmeticSequence();
        int[] A = {20,1,15,3,10,5,8};
        System.out.println(test.longestArithSeqLength(A));
    }

}