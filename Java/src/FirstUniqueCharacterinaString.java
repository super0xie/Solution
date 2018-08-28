import java.util.Arrays;

public class FirstUniqueCharacterinaString {
	
    public int firstUniqChar(String s) {
        int[] indice = new int [26];
        Arrays.fill(indice, -1);
        
        for(int i = 0; i < s.length(); i++) {
        	if(indice[s.charAt(i)-'a'] == -1)
        		indice[s.charAt(i)-'a'] = i;
        	else
        		indice[s.charAt(i)-'a'] = -2;
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
        	if(indice[i] >= 0 && indice[i] < result) result = indice[i];
        }
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
        
    }
}
