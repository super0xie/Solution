
public class LongestPalindromicSubstring {
	
    public String longestPalindrome(String s) {
    	if(s.length() == 0) return s;
        String res = s.substring(0, 1);
        int maxLen = 1;
        
        for(int i = 0; i < s.length(); i++) {
        	
    		int start = i-1;
        	int end = i+1;
        	int cur = 1;
        	while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        		cur+=2;
        		start--;
        		end++;
        	}
        	if(cur > maxLen) {
        		maxLen = cur;
        		res = s.substring(start+1, end);
        	}
        	
        	if(i != s.length()-1) {
        		start = i;
            	end = i+1;
            	cur = 0;
            	while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            		cur+=2;
            		start--;
            		end++;
            	}
            	if(cur > maxLen) {
            		maxLen = cur;
            		res = s.substring(start+1, end);
            	}
        	}
        	
        	
        }
    	return res;
    }
    
    public static void main(String[] args) {
    	LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    	test.longestPalindrome("ccc");
    	
    }

}
