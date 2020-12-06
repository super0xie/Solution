
public class MaximumNestingDepthoftheParentheses {
	
	public int maxDepth(String s) {
        int max = 0;
        int d = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') d++;
        	else if(s.charAt(i) == ')') d--;
        	max = Math.max(max, d);
        }
        return max;
    }
	
}
