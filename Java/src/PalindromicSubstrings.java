
public class PalindromicSubstrings {
	
	public int countSubstrings(String s) {
		
		int res = 0;
        for(int i = 0; i < s.length() * 2 - 1; i++) {
        	
        	if(i % 2 == 0) {
        		res++;
        		int l = i/2-1;
        		int r = i/2+1;
        		while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) res++;
        	}else {
        		int l = i/2;
        		int r = l+1;
        		while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) res++;
        		
        	}
        }
        
        return res;
    }
	
}
