import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileinSystem {
    
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : paths) {
            String[] strs = str.split(" ");
            String dir = strs[0];
            
            for(int i = 1; i < strs.length; i++) {
                int idxl = strs[i].indexOf('(');
                int idxr = strs[i].indexOf(')');
                
                String name = strs[i].substring(0, idxl);
                String content = strs[i].substring(idxl+1, idxr);
                
                List<String> list = map.getOrDefault(content, new ArrayList<String>());
                list.add(dir + "/" + name);
                map.put(content, list);
                
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        
        for(String key : map.keySet()) {
            if(map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        
        return res;
        
    }
    
}
