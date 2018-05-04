import java.util.ArrayList;
import java.util.Arrays;

public class GoatLatin {
	public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        
        ArrayList<Character> list = new ArrayList<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        
        String as = "a";
        for(int i = 0; i < strs.length; i++) {
        	if(list.contains(Character.toUpperCase(strs[i].charAt(0)))) {
        		strs[i] = strs[i] + "ma";
        	}else {
        		if(strs[i].length() > 1)
        			strs[i] = strs[i].substring(1) + strs[i].charAt(0);
        		strs[i] = strs[i] + "ma";
        	}
        	strs[i] = strs[i] + as;
        	as = as + "a";
        }
        
        String result = "";
        
        for(int i = 0; i < strs.length - 1; i++) {
        	result = result + strs[i] + " ";
        }
        result = result + strs[strs.length - 1];
        return result;
        
    }
	
	public static void main(String[] args) {
		GoatLatin gt = new GoatLatin();
		System.out.println(gt.toGoatLatin("I speak Goat Latin"));
		System.out.println(gt.toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

}
