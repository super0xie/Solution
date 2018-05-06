
public class LongestPalindrome {
	
    public int longestPalindrome(String s) {
    	int [] counter = new int [52];
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
        		counter[s.charAt(i) - 'a']++;
        	}else {
        		counter[26 + s.charAt(i) - 'A']++;
        	}
        }
        
        int result = 0;
        boolean hasOdd = false;
        for(int i = 0; i < 52; i++) {
        	if(counter[i] % 2 == 0) {
        		result += counter[i];
        	}else {
        		hasOdd = true;
        		result += counter[i] - 1;
        	}
        }
        
        if(hasOdd) result++;
        
        return result;
    }
	
	
	public static void main(String [] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.longestPalindrome("abccccdd"));
	}

}
