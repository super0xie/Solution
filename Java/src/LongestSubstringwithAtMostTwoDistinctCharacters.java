import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	map.merge(c, 1, Integer::sum);
        	
        	if(map.size() <= 2) {
        		int current = i - start + 1;
        		if(current > result) result = current;
        	}else {
        		while(map.size() > 2) {
        			char charToRemove = s.charAt(start);
        			if(map.get(charToRemove) == 1) {
        				map.remove(charToRemove);
        			}else {
        				map.merge(charToRemove, -1, Integer::sum);
        			}
        			start++;
        		}
        	}
        }
        
        return result;
    }
    
}
