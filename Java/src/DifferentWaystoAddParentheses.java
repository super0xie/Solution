import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	

    public List<Integer> diffWaysToCompute(String input) {
    	int count = 0;
    	for(int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == '*' || input.charAt(i) == '+' || input.charAt(i) == '-')
    			count++;
    	}
        return dfs(input, count);
    }
    
    private List<Integer> dfs(String str, int count) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(count == 0) {
    		res.add(Integer.parseInt(str));
    		return res;
    	}
    	
    	int curr = 0;
    	
    	for(int i = 0 ; i< str.length() ; i++) {
    		if(str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-') {
    			String leftStr = str.substring(0, i);
    			String rightStr = str.substring(i+1, str.length());
    			
    			List<Integer> l = dfs(leftStr, curr);
    			List<Integer> r = dfs(rightStr, count-curr-1);
    			
    			for(int a : l) {
    				for(int b : r) {
    					if(str.charAt(i) == '*') res.add(a*b);
    					else if(str.charAt(i) == '+') res.add(a+b);
    					else res.add(a-b);
    				}
    			}
    			
    			curr++;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	DifferentWaystoAddParentheses test = new DifferentWaystoAddParentheses();
    	List<Integer> result =test.diffWaysToCompute("2*3-4*5");
    	System.out.println("hello");
    }
    
    
    
    
}
