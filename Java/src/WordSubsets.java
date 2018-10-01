import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
	
	public List<String> wordSubsets(String[] A, String[] B) {
        
        int[] maxCount = new int[26];
        
        for(String str : B) {
        	int[] count = new int[26];
        	for(int i = 0; i < str.length(); i++) {
        		count[str.charAt(i) - 'a']++;
        	}
        	
        	for(int i = 0; i < 26; i++) {
        		maxCount[i] = Math.max(maxCount[i], count[i]);
        	}
        }
        
        List<String> res = new ArrayList<String>();
        
        for(String str : A) {
        	int[] count = new int[26];
        	for(int i = 0; i < str.length(); i++) {
        		count[str.charAt(i) - 'a']++;
        	}
        	int i = 0;
        	for(; i < 26; i++) {
        		if(count[i] < maxCount[i]) break;
        	}
        	if(i == 26) res.add(str);
        	
        }
        
        return res;
    }
	
}
