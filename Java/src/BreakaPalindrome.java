
public class BreakaPalindrome {
	
	public String breakPalindrome(String p) {
		if(p.length() <= 1) return "";
        char[] c = p.toCharArray();
        for(int i = 0; i < (p.length()) / 2; i++) {
        	if(c[i] != 'a') {
        		c[i] = 'a';
        		return String.valueOf(c);
        	}
        }
        
        c[p.length()-1] = 'b';
        return String.valueOf(c);
    }
	
	public static void main(String[] args) {
		BreakaPalindrome test = new BreakaPalindrome();
		System.out.println(test.breakPalindrome("aba"));
	}
	
}
