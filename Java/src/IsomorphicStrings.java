import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }else {
                char v = t.charAt(i);
                if(map.containsValue(v)) return false;
                map.put(s.charAt(i), v);
            }
            
        }
        
        return true;
        
    }
}
