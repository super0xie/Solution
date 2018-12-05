
public class ShortestCompletingWord {
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for(int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if(c >= 'a' && c <= 'z')
                count[c-'a']++;
            else if(c >= 'A' && c <= 'Z') {
                count[c-'A']++;
            }
        }
        
        String res = null;
        int len = Integer.MAX_VALUE;
        for(String str : words) {
            int[] c = new int[26];
            for(int i = 0; i < str.length(); i++) {
                c[licensePlate.charAt(i)-'a']++;
            }
            int i = 0;
            for(; i < 26; i++) {
                if(c[i] < count[i]) break;
            }
            
            if(i == 26) {
                if(len > str.length()) {
                    res = str;
                    len = str.length();
                }
            }
        }
        
        return res;
    }
    
}
