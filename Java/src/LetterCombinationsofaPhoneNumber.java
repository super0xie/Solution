import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	private static char[][] table = {
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}};
	
	private ArrayList<String> result;
	
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
        	return result;
        
        helper(digits, 0, "");
        
        return result;
    }
    
    private void helper(String digits, int index, String current) {
    	int row = digits.charAt(index) - '2';
    	
    	for(int i = 0; i < table[row].length; i++) {
    		String modified = current + table[row][i];
    		if(index == digits.length()-1) {
    			result.add(modified);
    		}else {
    			helper(digits, index+1, modified);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	LetterCombinationsofaPhoneNumber test = new LetterCombinationsofaPhoneNumber();
    	System.out.println(test.letterCombinations("23"));
    }
}
