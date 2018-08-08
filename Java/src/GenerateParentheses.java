import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	int n;
	List<String> result;
	
	
	public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        this.n = n;
        helper(0, 0, "");
        
        return result;
    }
	
	private void helper(int left, int right, String current) {
		if(current.length() == 2*n) {
			result.add(current);
			return;
		}
		
		if(left < n)
			helper(left+1, right, current+"(");
		
		if(right < left)
			helper(left, right+1, current+")");
		
	}
	
	
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		List<String> result = test.generateParenthesis(3);
		
		System.out.println(result);
	}

}
