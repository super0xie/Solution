import java.util.HashSet;


public class MinimumRemovetoMakeValidParentheses {
	
	public String minRemoveToMakeValid(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		sum++;
        	} else if(s.charAt(i) == ')') {
        		if(sum == 0) set.add(i);
        		else sum--;
        	}
        }
        
        sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
        	if(s.charAt(i) == '(') {
        		if(sum == 0) set.add(i);
        		else sum++;
        	} else if(s.charAt(i) == ')') {
        		sum--;
        	}
        }

        for(int i = 0; i < s.length(); i++) {
        	if(!set.contains(i)) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		MinimumRemovetoMakeValidParentheses test = new MinimumRemovetoMakeValidParentheses();
		System.out.println(test.minRemoveToMakeValid("(a(b(c)d)"));
	}
	
}
