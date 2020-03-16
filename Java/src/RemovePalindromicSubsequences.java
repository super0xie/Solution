
public class RemovePalindromicSubsequences {
	
	public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        int i = 0;
        int j = s.length()-1;
        boolean pal = true;
        while(i < j) {
        	if(s.charAt(i++) != s.charAt(j--)) pal = false;
        }
        
        if(pal) return 1;
        return 2;
    }
	
}
