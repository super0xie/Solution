import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for(String str : strs) {
    		int [] charCount = new int[26];
    		for(int i = 0; i < str.length(); i++) {
    			charCount[str.charAt(i)-'a']++;
    		}
    		String key = "";
    		for(int i = 0; i < 26; i++) {
    			key = key + charCount[i];
    		}
    		if(map.containsKey(key)) {
    			List<String> list = map.get(key);
    			list.add(str);
    		}else {
    			List<String> list = new ArrayList<String>();
    			list.add(str);
    			map.put(key, list);
    			result.add(list);
    		}
    		
    	}
    	
    	
    	
    	return result;
    }
    
}
