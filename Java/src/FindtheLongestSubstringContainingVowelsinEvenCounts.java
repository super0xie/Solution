import java.util.Arrays;
import java.util.HashMap;

public class FindtheLongestSubstringContainingVowelsinEvenCounts {
    
    public int findTheLongestSubstringOld(String s) {
        int[][] count = new int[5][s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            
            if(i > 0) {
                for(int j = 0; j < 5; j++) {
                    count[j][i] = count[j][i-1];
                }
            }
            
            if(idx >= 0) {
                count[idx][i]++;
            }
        }
        
        
        for(int len = s.length(); len >= 1; len--) {
            for(int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                int k = 0;
                for(; k < 5; k++) {
                    int c;
                    if(i == 0) c = count[k][j];
                    else c = count[k][j] - count[k][i-1];
                    if(c % 2 == 1) break;
                }
                if(k == 5) return len;
            }
        }
        
        return 0;
    }
    
    public int findTheLongestSubstringV1(String s) {
        int[] prefix = new int[s.length()+1];
        int cur = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            
            if(idx >= 0) {
                int n = 1;
                for(int j = 0; j < idx; j++) n = n << 1;
                cur = cur ^ n;
            }
            prefix[i+1] = cur;
        }
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i <= s.length(); i++) {
            if(map.containsKey(prefix[i])) {
                res = Math.max(res, i-map.get(prefix[i]));
            }else {
                map.put(prefix[i], i);
            }
        }
        
        return res;
    }
    
    public int findTheLongestSubstring(String s) {
        int[] prefix = new int[s.length()+1];
        int cur = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            
            if(idx >= 0) {
                int n = 1;
                for(int j = 0; j < idx; j++) n = n << 1;
                cur = cur ^ n;
            }
            prefix[i+1] = cur;
        }
        
        
        int[] map = new int[32];
        Arrays.fill(map, -1);
        int res = 0;
        
        for(int i = 0; i <= s.length(); i++) {
            if(map[prefix[i]] >= 0) {
                res = Math.max(res, i-map[prefix[i]]);
            }else {
                map[prefix[i]] = i;
            }
        }
        
        return res;
    }
    
    
    private int getIdx(char c) {
        if(c == 'a') return 0;
        else if(c == 'e') return 1;
        else if(c == 'i') return 2;
        else if(c == 'o') return 3;
        else if(c == 'u') return 4;
        return -1;
    }
    
    public static void main(String[] args) {
        FindtheLongestSubstringContainingVowelsinEvenCounts test = new FindtheLongestSubstringContainingVowelsinEvenCounts();
        System.out.println(test.findTheLongestSubstring("eleetminicoworoep"));
    }
}
