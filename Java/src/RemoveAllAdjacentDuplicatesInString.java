
public class RemoveAllAdjacentDuplicatesInString {
	
	public String removeDuplicates(String S) {
        boolean cont = true;
        while(cont) {
        	cont = false;
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < S.length(); i++) {
        		if(i < S.length()-1 && S.charAt(i) == S.charAt(i+1)) {
        			i = i + 1;
        			cont = true;
        		}else {
        			sb.append(S.charAt(i));
        		}
        	}
        	
        	S = sb.toString();
        }
        
        return S;
    }
	
}
