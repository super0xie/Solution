import java.util.HashMap;
import java.util.HashSet;

public class ImplementMagicDictionary {
	
	HashMap<String, Integer> map;
	HashSet<String> set;
	public ImplementMagicDictionary() {
        map = new HashMap<String, Integer>();
        set = new HashSet<String>();
    }
    
    public void buildDict(String[] dict) {
    	
    	for(String str: dict) {
    		set.add(str);
    		char[] chars = str.toCharArray();
    		for(int i = 0; i < chars.length; i++) {
    			char c = chars[i];
    			chars[i] = '*';
    			String mod = String.valueOf(chars);
    			chars[i] = c;
    			map.merge(mod, 1, Integer::sum);
    		}
    		
    	}
    	
        
    }
    
    public boolean search(String word) {
    	char[] chars = word.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			char c = chars[i];
			chars[i] = '*';
			String mod = String.valueOf(chars);
			chars[i] = c;
			if(!map.containsKey(mod)) continue;
			
			if(map.get(mod) > 1) return true;
			else{
				if(set.contains(word)) continue;
				else return true;
			}
		}
		
		return false;
    }
    
    public static void main(String[] args) {
    	ImplementMagicDictionary test = new ImplementMagicDictionary();
    	String [] strs = {"hello","leetcode"};
    	test.buildDict(strs);
    	System.out.println(test.search("hhllo"));
    }
    
}
