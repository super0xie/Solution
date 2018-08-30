import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    
    
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strings) {
            StringBuilder key = new StringBuilder();
            int offset = str.charAt(0) - 'a';
            
            
            for(int i = 0; i < str.length(); i++) {
                char downShifted = (char) (str.charAt(i) - offset);
                if(downShifted < 'a') {
                    downShifted += 26;
                }
                key.append(downShifted);
            }
            
            String strKey = key.toString();
            if(map.containsKey(strKey)) {
                map.get(strKey).add(str);
            }else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(strKey, list);
                
            }
        }
        
        for(String key : map.keySet()) {
            result.add(map.get(key));
        }
        
        return result;
    }
    
    
}
