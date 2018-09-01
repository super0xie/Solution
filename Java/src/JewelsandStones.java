
public class JewelsandStones {
	
    public int numJewelsInStones(String J, String S) {
        boolean [] upper = new boolean [26];
        boolean [] lower = new boolean [26];
        
        for(int i = 0; i < J.length(); i++) {
        	char c = J.charAt(i);
        	if(c <= 'Z' && c >= 'A') upper[c-'A'] = true;
        	else lower[c-'a'] = true;
        }
        
        int res = 0;
        
        for(int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if(c <= 'Z' && c >= 'A' && upper[c-'A']) res++;
        	else if(c <= 'z' && c >= 'a' && lower[c-'a']) res++;
        }
        
        return res;
    }
}
