
public class ReverseSubstringsBetweenEachPairofParentheses {
	
	public String reverseParentheses(String s) {
        StringBuilder sb = helper(s);
        return sb.toString();
    }
	
	private StringBuilder helper(String s) {
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		
        		int count = 1;
        		int j = i+1;
        		for(; j < s.length(); j++) {
        			if(s.charAt(j) == '(') count++;
        			else if(s.charAt(j) == ')') {
        				count--;
        				if(count == 0) break;
        			}
        		}
        		StringBuilder sub = helper(s.substring(i+1, j));
        		sb.append(sub.reverse());
        		i = j;
        	}else {
        		sb.append(s.charAt(i));
        	}
        }
        
        return sb;
	}
	
	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairofParentheses test = new ReverseSubstringsBetweenEachPairofParentheses();
		System.out.println(test.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}
	
}
