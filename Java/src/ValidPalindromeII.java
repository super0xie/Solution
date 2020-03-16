
public class ValidPalindromeII {
	
	public boolean validPalindrome(String s) {
        return helper(s, false);
    }
	
	private boolean helper(String s, boolean deleted) {
		int i = 0;
        int j = s.length()-1;
        while(i <= j) {
        	if(s.charAt(i) == s.charAt(j)) {
        		i++;
        		j--;
        	}else {
        		if(deleted) return false;
        		deleted = true;
        		if(s.charAt(j-1) == s.charAt(i) && helper(s.substring(i, j), true)) return true;
        		else if(s.charAt(i+1) == s.charAt(j) && helper(s.substring(i+1, j+1), true)) return true;
        		else return false;
        	}
        }
        
        return true;
	}
	
	public static void main(String[] args) {
		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		ValidPalindromeII test = new ValidPalindromeII();
		System.out.println(test.validPalindrome(s));
	}
	
}
