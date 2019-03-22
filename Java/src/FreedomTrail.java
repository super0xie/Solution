import java.util.ArrayList;

public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        ArrayList<Integer>[][] dp = new ArrayList[26][2];

        for(int i = 0; i < ring.length(); i++){
            if(dp[ring.charAt(i)-'a'][0] == null){
                dp[ring.charAt(i)-'a'][0] = new ArrayList<>();
                dp[ring.charAt(i)-'a'][1] = new ArrayList<>();
            }

            dp[ring.charAt(i)-'a'][0].add(i);
            dp[ring.charAt(i)-'a'][1].add(0);
        }

        for(int i = 0; i < dp[key.charAt(0)-'a'][0].size(); i++){
            int idx = dp[key.charAt(0)-'a'][0].get(i);
            dp[key.charAt(0)-'a'][1].set(i, dis(ring.length(), 0, idx)+1);
        }

        for(int i = 1; i < key.length(); i++){
            for(int j = 0; j < dp[key.charAt(i)-'a'][0].size(); j++){
                int min = Integer.MAX_VALUE;

                for(int k = 0; k < dp[key.charAt(i-1)-'a'][0].size(); k++){
                    min = Math.min(min, dis(ring.length(), dp[key.charAt(i)-'a'][0].get(j), dp[key.charAt(i-1)-'a'][0].get(k)) + dp[key.charAt(i-1)-'a'][1].get(k) + 1);
                }

                dp[key.charAt(i)-'a'][1].set(j, min);
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i : dp[key.charAt(key.length()-1)-'a'][1]){
            res = Math.min(res, i);
        }
        return res;
    }

    private int dis(int len, int i, int j){
        int abs = Math.abs(i-j);
        return Math.min(abs, len-abs);
    }

    public static void main(String[] args) {
        FreedomTrail test = new FreedomTrail();
        System.out.println(test.findRotateSteps("zvyii", "iivyz"));
    }

}