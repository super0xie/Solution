import java.util.Arrays;

public class LongestStringChain{

    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];

        Arrays.sort(words, (a, b)->{return a.length() - b.length();});
        int res = 0;
        for(int i = 0; i < words.length; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(isSubseq(words[j], words[i]))
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    private boolean isSubseq(String a, String b){
    	if(a.length() != b.length()-1) return false;
        int j = 0;
        for(int i = 0; i < b.length(); i++){
            if(a.charAt(j) == b.charAt(i)) j++;
            if(j == a.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"wnyxmflkf","xefx","usqhb","ttmdvv","hagmmn","tmvv","pttmdvv","nmzlhlpr","ymfk","uhpaglmmnn","zckgh","hgmmn","isqxrk","isqrk","nmzlhpr","uysyqhxb","haglmmn","xfx","mm","wymfkf","tmdvv","uhaglmmn","mf","uhaglmmnn","mfk","wnymfkf","powttkmdvv","kwnyxmflkf","xx","rnqbhxsj","uysqhb","pttkmdvv","hmmn","iq","m","ymfkf","zckgdh","zckh","hmm","xuefx","mv","iqrk","tmv","iqk","wnyxmfkf","uysyqhb","v","m","pwttkmdvv","rnqbhsj"};
        LongestStringChain test = new LongestStringChain();
        System.out.println(test.longestStrChain(words));
    }

}