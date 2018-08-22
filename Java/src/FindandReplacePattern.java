import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindandReplacePattern {
    
    
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<String>();
        
        for(String word : words) {
            if(helper(word, pattern)) result.add(word);
        }
        
        return result;
        
    }
    
    private boolean helper(String word, String pattern) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        for(int i = 0; i < word.length(); i++) {
            if(map.containsKey(word.charAt(i))) {
                if(!map.get(word.charAt(i)).equals(pattern.charAt(i))) {
                    return false;
                }
            }else {
                if(map.containsValue(pattern.charAt(i))) return false;
                map.put(word.charAt(i), pattern.charAt(i));
            }
        }
        
        return true;

    }


}
