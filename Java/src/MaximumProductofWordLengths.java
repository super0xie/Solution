import java.util.Arrays;

public class MaximumProductofWordLengths {
    
    public int maxProduct(String[] words) {
        
        Arrays.sort(words, (a, b)->{
            return b.length() - a.length();
        });
        
        int[][] counts = new int [words.length][26];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                counts[i][words[i].charAt(j)-'a']++;
            }
        }
        
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            if(res >= words[i].length() * words[i].length()) break;
            for(int j = i+1; j < words.length; j++) {
                if(!hasCommonLetter(counts, i, j)){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
    
    private boolean hasCommonLetter(int[][] counts, int i, int j) {
        for(int k = 0; k < 26; k++) {
            if(counts[i][k] > 0 && counts[j][k] > 0) return true;
        }
        return false;
    }

}
