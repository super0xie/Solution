import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        
        for(int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!strs[i].equals(map.get(pattern.charAt(i)))) return false;
            }else {
                if(set.contains(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
