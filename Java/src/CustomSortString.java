import java.util.ArrayList;
import java.util.Collections;

public class CustomSortString {
	
	public String customSortString(String S, String T) {
        int[] indice = new int[26];
        for(int i = 0; i < S.length(); i++) {
        	indice[S.charAt(i) - 'a'] = i;
        }
        
        ArrayList<Character> list = new ArrayList<Character>();
        
        for(int i = 0; i < T.length(); i++) {
        	list.add(T.charAt(i));
        }
        
        Collections.sort(list, (a,b)->{return indice[a-'a'] - indice[b-'a'];});
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : list) {
        	sb.append(c);
        }
        return sb.toString();
        
    }

}
