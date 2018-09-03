import java.util.Arrays;

public class ReorganizeString {
	
    public String reorganizeString(String S) {
    	if(S.length() <= 1) return S;
    	
        int[] count = new int[26];
        Integer[] index = new Integer[26];
        
        for(int i = 0; i < 26; i++) {
        	index[i] = i;
        }
        for(char c : S.toCharArray()) {
        	count[c - 'a']++;
        	if(count[c-'a'] > (S.length()+1) / 2) return "";
        }
        
        Arrays.sort(index, (a, b)->{
        	return count[b] - count[a];
        });
        
        
        char [] res = new char [S.length()];
        
        boolean even = true;
        int counter = 0;
        int i = 0;
        int a = 0;
        while(counter < S.length()) {
        	res[i] = (char) ('a' + index[a]);
    		count[index[a]]--;
    		if(count[index[a]] == 0) a++;
    		i = i + 2;
    		if(i >= S.length()) {
    			i = 1;
    		}
        	
        	counter++;
        }
        
        
        return String.valueOf(res);
        
        
    }
    
    public static void main(String[] args) {
    	ReorganizeString test = new ReorganizeString();
    	System.out.println(test.reorganizeString("a"));
    }
    
}
