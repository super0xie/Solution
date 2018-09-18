import java.util.Collections;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
	
	public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b) -> {
        	if(a.length() != b.length())
        		return b.length()-a.length();
        	else {
        		return a.compareTo(b);
        	}
        });
        
        char[] chars = s.toCharArray();
        for(String str : d) {
        	int i = 0;
        	for(char c : chars) {
        		if(i < str.length() && str.charAt(i) == c) i++;
        	}
        	
        	if(i == str.length()) return str;
        }
        return "";
        
    }
}
