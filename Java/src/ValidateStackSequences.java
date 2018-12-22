import java.util.Stack;

public class ValidateStackSequences {
	
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	if(pushed.length == 0) return true;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(j < popped.length) {
        	if(stack.isEmpty()) {
        		if(i < pushed.length) stack.push(pushed[i]);
        		else return false;
        	}
        	if(popped[j] == stack.peek()) {
        		stack.pop();
        		j++;
        	}else if(i >= pushed.length){
        		return false;
        	}else {
        		stack.push(pushed[i++]);
        	}
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	int[] pushed = {1,0};
    	int[] popped = {1,0};
    	ValidateStackSequences test = new ValidateStackSequences();
    	System.out.println(test.validateStackSequences(pushed, popped));
    }
    
}
