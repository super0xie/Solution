
public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		
		String str = Integer.toString(x);
		
		int i = 0;
		int j = str.length() - 1;
		
		while(i <= j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}else {
				i++;
				j--;
			}
			
		}
		
		return true;
		
        
    }
	
	
}
