
public class ReplaceAllstoAvoidConsecutiveRepeatingCharacters {
	
	public String modifyString(String s) {
        char[] res = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '?') {
        		if(i == 0) res[i] = 'a';
        		else {
        			if(res[i-1] == 'z') res[i] = 'a';
        			else res[i] = (char)(res[i-1]+1);
        		}
        		
        		if(i < s.length()-1 && s.charAt(i+1) == res[i]) {
    				if(s.charAt(i+1) == 'z') res[i] = 'a';
    				else res[i] = (char)(s.charAt(i+1)+1);
    			}
        		
        	}else res[i] = s.charAt(i);
        }
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		String s = "?a?ub???w?b";
		ReplaceAllstoAvoidConsecutiveRepeatingCharacters test = new ReplaceAllstoAvoidConsecutiveRepeatingCharacters();
		test.modifyString(s);
	}
	
}
