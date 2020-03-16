
public class ExpressiveWords {
	
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        
        for(String str : words) {
        	int i = 0;
        	int j = 0;
        	
        	while(i < S.length() && j < str.length()) {
        		if(S.charAt(i) != str.charAt(j)) break;
        		
        		int ii = i;
        		while(ii < S.length() && S.charAt(ii) == S.charAt(i)) ii++;
        		
        		int jj = j;
        		while(jj < str.length() && str.charAt(jj) == str.charAt(j)) jj++;
        		
        		if(ii-i == jj-j || (ii-i >= 3 && ii-i >= jj-j)) {
        			i = ii;
        			j = jj;
        		}else break;
        	}
        	
        	if(i == S.length() && j == str.length()) res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	String[] words = {"hello"};
    	ExpressiveWords test = new ExpressiveWords();
    	test.expressiveWords("heeellooo", words);
    }
    
}
