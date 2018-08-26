
public class RepeatedStringMatch {
	
    public int repeatedStringMatch(String A, String B) {
        int min = (int)Math.ceil(B.length() / (double)A.length());
        
        StringBuffer concatA = new StringBuffer(A);
        for(int i = 0; i < min-1; i++) {
        	concatA.append(A);
        }
        
        if(concatA.indexOf(B) >= 0) return min;
        else if(concatA.append(A).indexOf(B) >= 0) return min+1;
        else return -1;
        
    }
    
}
