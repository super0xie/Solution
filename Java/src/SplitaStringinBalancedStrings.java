
public class SplitaStringinBalancedStrings {
	
	public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == 'L') count++;
        	else count--;
        	
        	if(count == 0) res++;
        }
        return res;
    }
	
}
