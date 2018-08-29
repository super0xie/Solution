import java.util.HashMap;
import java.util.HashSet;

public class SentenceSimilarity {
	
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    	if(words1.length != words2.length) return false;
    	HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
    	
        for(int i = 0; i < pairs.length; i++) {
        	if(map.containsKey(pairs[i][0])) {
        		map.get(pairs[i][0]).add(pairs[i][1]);
        	}else {
        		HashSet<String> set = new HashSet<String>();
        		set.add(pairs[i][1]);
        		map.put(pairs[i][0], set);
        	}
        	
        	if(map.containsKey(pairs[i][1])) {
        		map.get(pairs[i][1]).add(pairs[i][0]);
        	}else {
        		HashSet<String> set = new HashSet<String>();
        		set.add(pairs[i][0]);
        		map.put(pairs[i][1], set);
        	}
        }
        
        
        for(int i = 0; i < words1.length; i++) {
        	if(!words1[i].equals(words2[i]) && !map.get(words1[i]).contains(words2[i])) return false;
        }
        
        return true;
    }
    
}
