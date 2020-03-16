import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
	
	public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        
        for(String str : A) {
        	int[] tmp = new int[26];
        	for(int i = 0; i < str.length(); i++) {
        		tmp[str.charAt(i)-'a']++;
        	}
        	
        	for(int i = 0; i < 26; i++) {
        		count[i] = Math.min(count[i], tmp[i]);
        	}
        }
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
        	while(count[i] > 0) {
        		res.add("" + (char)('a' + i));
        		count[i]--;
        	}
        }
        
        return res;
    }
	
}
