import java.util.ArrayList;
import java.util.HashMap;

public class UncommonWordsfromTwoSentences {
    
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        
        for(String str : a) {
            map1.put(str, map1.getOrDefault(str, 0)+1);
        }
        for(String str : b) {
            map2.put(str, map2.getOrDefault(str, 0)+1);
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        for(String str : map1.keySet()) {
            if(map1.get(str) == 1 && !map2.containsKey(str)) res.add(str);
        }
        
        for(String str : map2.keySet()) {
            if(map2.get(str) == 1 && !map1.containsKey(str)) res.add(str);
        }
        
        return res.toArray(new String[res.size()]);
    }
    
}
