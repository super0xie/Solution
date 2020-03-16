
public class LongestRepeatingCharacterReplacement {
	
    public int characterReplacement(String s, int k) {
    	if(s.length() <= k) return s.length();
        int i = 0;
        int j = 0;
        
        int[] count = new int[26];
        count[s.charAt(0)-'A']++;
        int res = k;
        while(i <= j && j < s.length()) {
        	int max = 0;
        	for(int n = 0; n < 26; n++) {
        		max = Math.max(max, count[n]);
        	}
        	
        	if(j-i+1-max <= k) {
        		res = Math.max(res, j-i+1);
        		j++;
        		if(j < s.length())
        			count[s.charAt(j) - 'A']++;
        	}else {
        		count[s.charAt(i) - 'A']--;
        		i++;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	LongestRepeatingCharacterReplacement test = new LongestRepeatingCharacterReplacement();
    	System.out.println(test.characterReplacement("ABAB", 2));
    }
    
}
