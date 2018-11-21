import java.util.Arrays;

public class ShortestDistancetoaCharacter {
    
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, Integer.MAX_VALUE);
        int last = -1;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                last = i;
                res[i] = 0;
            }
            else {
                if(last >= 0) {
                    res[i] = Math.min(res[i], i-last);
                }
            }
        }
        last = -1;
        for(int i = S.length()-1; i >= 0; i--) {
            if(S.charAt(i) == C) last = i;
            else {
                if(last >= 0) {
                    res[i] = Math.min(res[i], last-i);
                }
            }
        }
        return res;
    }
    
}
