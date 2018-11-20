import java.util.ArrayList;

public class KeyboardRow {
    
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        
        int[] row = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        for(String word : words) {
            int i = 1;
            for(; i < word.length(); i++) {
                if(row[idx(word.charAt(i))] != row[idx(word.charAt(i-1))]) break;
            }
            if(i == word.length()) res.add(word);
            
        }
        String[] ret = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    private int idx(char c) {
        if(c >= 'a') return c-'a';
        else return c-'A'; 
    }
    
    public static void main(String[] args) {
        KeyboardRow test = new KeyboardRow();
        String[] words = {"qwee"};
        test.findWords(words);
    }
    
}
