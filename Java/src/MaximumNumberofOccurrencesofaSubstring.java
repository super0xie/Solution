import java.util.HashMap;

public class MaximumNumberofOccurrencesofaSubstring {
	
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        
        
        for(int len = minSize; len <= maxSize; len++) {
        	HashMap<String, Integer> map = new HashMap<>();
        	int[] count = new int[26];
        	int let = 0;
        	for(int i = 0; i < s.length(); i++) {
        		count[s.charAt(i)-'a']++;
        		if(count[s.charAt(i)-'a'] == 1) let++;
        		
        		if(i - len >= 0) {
        			count[s.charAt(i-len)-'a']--;
        			if(count[s.charAt(i-len)-'a'] == 0) let--;
        		}
        		
        		if(let <= maxLetters && i >= len-1) {
        			String sub = s.substring(i-len+1, i+1);
        			int n = map.getOrDefault(sub, 0)+1;
        			map.put(sub, n);
        			res = Math.max(res, n);
        		}
        		
        	}
        
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumNumberofOccurrencesofaSubstring test = new MaximumNumberofOccurrencesofaSubstring();
		System.out.println(test.maxFreq("abcde", 2, 3, 3));
	}
	
}
