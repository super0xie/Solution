import java.util.HashMap;

public class ArithmeticSlicesIISubsequence {

    public int numberOfArithmeticSlicesOld(int[] A) {
        if(A.length == 0) return 0;
        HashMap<Integer, HashMap<Integer, Integer>>[] dp = new HashMap[A.length];
        int res = 0;
        dp[0] = new HashMap<>();

        for(int i = 1; i < A.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int diff = A[i]-A[j];
                HashMap<Integer, Integer> lcm = null;

                if(dp[i].containsKey(diff)){
                    lcm = dp[i].get(diff);
                }else{
                    lcm = new HashMap<>();
                    dp[i].put(diff, lcm);
                }
                
                if(dp[j].containsKey(diff)){
                    for(int len : dp[j].get(diff).keySet()){
                        int newLen = len+1;
                        lcm.put(newLen, lcm.getOrDefault(newLen, 0)+dp[j].get(diff).get(len));
                    }
                }
                
                int newLen = 2;
                lcm.put(newLen, lcm.getOrDefault(newLen, 0) + 1);

            }

            for(int diff : dp[i].keySet()){
                for(int len : dp[i].get(diff).keySet()){
                    if(len >= 3) res += dp[i].get(diff).get(len);
                }
            }

        }
        return res;
    }

    public int numberOfArithmeticSlicesTLE(int[] A) {
        if(A.length == 0) return 0;
        HashMap<Long, HashMap<Integer, Integer>>[] dp = new HashMap[A.length];
        int res = 0;
        dp[0] = new HashMap<>();

        for(int i = 1; i < A.length; i++){
            if(i == 998) {
                System.out.println("test");
            }
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                Long diff = (long)A[i]-A[j];
                HashMap<Integer, Integer> lcm = null;

                if(dp[i].containsKey(diff)){
                    lcm = dp[i].get(diff);
                }else{
                    lcm = new HashMap<>();
                    dp[i].put(diff, lcm);
                }
                
                if(dp[j].containsKey(diff)){
                    for(int len : dp[j].get(diff).keySet()){
                        int newLen = len+1;
                        lcm.put(newLen, lcm.getOrDefault(newLen, 0)+dp[j].get(diff).get(len));
                    }
                }
                
                int newLen = 2;
                lcm.put(newLen, lcm.getOrDefault(newLen, 0) + 1);

            }

            for(long diff : dp[i].keySet()){
                for(int len : dp[i].get(diff).keySet()){
                    if(len >= 3) res += dp[i].get(diff).get(len);
                }
            }

        }
        return res;
    }
    
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length == 0) return 0;
        HashMap<Long, Integer>[] dp = new HashMap[A.length];
        int res = 0;
        dp[0] = new HashMap<>();

        for(int i = 1; i < A.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                Long diff = (long)A[i]-A[j];
                if(dp[j].containsKey(diff)){
                    res += dp[j].get(diff);
                    dp[i].put(diff, dp[i].getOrDefault(diff, 0) + dp[j].get(diff));
                }
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        ArithmeticSlicesIISubsequence test = new ArithmeticSlicesIISubsequence();
        int[] A = {0,2000000000,-294967296};
        System.out.println(test.numberOfArithmeticSlices(A));
    }

}