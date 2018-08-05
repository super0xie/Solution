
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        String str = s.toLowerCase().replaceAll("\\W+", "");
        int i = 0;
        int j = str.length() - 1;
        
        while(i < j) {
        	if(str.charAt(i) != str.charAt(j)) return false;
        	i++;
        	j--;
        }
        
        return true;
    }
}
