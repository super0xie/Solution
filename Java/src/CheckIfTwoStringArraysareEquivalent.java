
public class CheckIfTwoStringArraysareEquivalent {
	
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int m = 0;
        int n = 0;
        
        for(int i = 0; i < word1.length; i++) {
        	for(int j = 0; j < word1[i].length(); j++) {
        		if(n == word2[m].length()) {
        			n = 0;
        			m++;
        		}
        		
        		if(m == word2.length) return false;
        		if(word1[i].charAt(j) != word2[m].charAt(n)) return false;
        		n++;
        	}
        }
        
        if(m != word2.length-1 || n != word2[m].length()) return false;
		
		return true;
    }
	
	public static void main(String[] args) {
		CheckIfTwoStringArraysareEquivalent test = new CheckIfTwoStringArraysareEquivalent();
		test.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"});
	}
	
}
