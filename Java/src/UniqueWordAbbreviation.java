import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {
	
	private HashMap<String, HashSet<String>> map;
	
	public void ValidWordAbbr(String[] dictionary) {
		map = new HashMap<String, HashSet<String>>();
        for(String str: dictionary) {
        	String abv;
        	if(str.length() <= 2) {
        		abv = str;
        	}else {
        		abv = "" + str.charAt(0) + (str.length()-2) + str.charAt(str.length()-1);
        	}
        	
        	if(map.containsKey(abv)) {
        		map.get(abv).add(str);
        	}else {
        		HashSet<String> set = new HashSet<String>();
        		set.add(str);
        		map.put(abv, set);
        	}
        	
        }
        
    }
    
    public boolean isUnique(String word) {
    	String abv;
    	if(word.length() <= 2) {
    		abv = word;
    	}else {
    		abv = "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1);
    	}
    	
    	if(map.containsKey(abv)) {
    		if(map.get(abv).size() == 1 && map.get(abv).contains(word)) return true;
    		return false;
    	}else {
    		return true;
    	}
    	
    }
}
