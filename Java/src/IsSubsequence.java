
public class IsSubsequence {
	
	public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        
        for(i = 0; i < s.length(); i++) {
        	boolean found = false;
        	while(j < t.length()) {
        		if(t.charAt(j) == s.charAt(i)) {
        			found = true;
        			j++;
        			break;
        		}else {
        			j++;
        		}
        	}
        	if(!found) return false;
        }
        
        return true;
    }
	
	
	public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(char c : t.toCharArray()) {
        	if(i < s.length() && s.charAt(i) == c) i++;
        }
        if(i == s.length()) return true;
        else return false;
    }
	
	

}
