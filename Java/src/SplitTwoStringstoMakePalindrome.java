
public class SplitTwoStringstoMakePalindrome {
	
	public boolean checkPalindromeFormation(String a, String b) {
		if(helper(a, b, a)) return true;
		if(helper(b, a, a)) return true;
		if(helper(a, b, b)) return true;
		if(helper(b, a, b)) return true;
		return false;
    }
	
	private boolean helper(String a, String b, String start) {
		int l = (a.length()-1)/2;
        int r = l;
        if(a.length() % 2 == 0) r = l+1;
		boolean switched = false;
        while(l >= 0) {
        	if(!switched) {
        		if(start.charAt(l) == start.charAt(r)) {
            		l--;
            		r++;
            	}else {
            		switched = true;
            	}
        	}else {
        		if(a.charAt(l) == b.charAt(r)) {
        			l--;
        			r++;
        		}else {
        			break;
        		}
        	}
        }
        if(l < 0) return true;
        return false;
	}
	
	public static void main(String[] args) {
		SplitTwoStringstoMakePalindrome test = new SplitTwoStringstoMakePalindrome();
		
		System.out.println(test.checkPalindromeFormation("abccef", "cgdhga"));
	}
	
}
