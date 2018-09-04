
public class BackspaceStringCompare {
	
    public boolean backspaceCompare(String S, String T) {
        int a = S.length()-1;
        int b = T.length()-1;
        int aCount = 0;
        int bCount = 0;
        
        while(a >= 0 || b >= 0) {
        	if(a >= 0 && S.charAt(a) == '#') {
        		aCount++;
        		a--;
        		continue;
        	}
        	
        	if(b >= 0 && T.charAt(b) == '#') {
        		bCount++;
        		b--;
        		continue;
        	}
        	
        	if(a >= 0 && aCount > 0) {
        		a--;
        		aCount--;
        		continue;
        	}
        	
        	if(b >= 0 && bCount > 0) {
        		b--;
        		bCount--;
        		continue;
        	}
        	
        	if(a >= 0 && b >= 0) {
        		if(S.charAt(a) != T.charAt(b)) return false;
        		else {
        			a--;
        			b--;
        		}
        		continue;
        	}
        	
        	if(( a >= 0 && b < 0 )||( a < 0 && b >= 0)) return false; 
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	BackspaceStringCompare test = new BackspaceStringCompare();
    	System.out.println(test.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

}
