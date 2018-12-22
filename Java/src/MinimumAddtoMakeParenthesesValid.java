
public class MinimumAddtoMakeParenthesesValid {
	
	public int minAddToMakeValid(String S) {
        int res = 0;
        int l = 0;
        int r = 0;
        
        for(int i = 0; i < S.length(); i++) {
        	if(S.charAt(i) == '(') {
        		l++;
        	}else {
        		r++;
        	}
        	
        	if(r > l) {
        		res++;
        		l++;
        	}
        }
        
        if(l > r) {
        	res += l-r;
        }
        return res;
    }
	
	public static void main(String[] args) {
		MinimumAddtoMakeParenthesesValid test = new MinimumAddtoMakeParenthesesValid();
		System.out.println(test.minAddToMakeValid("()))(("));
	}
}
