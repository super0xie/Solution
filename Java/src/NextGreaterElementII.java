import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	
	
	public int[] nextGreaterElements(int[] nums) {
        
		int[] res = new int [nums.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int j = 0; j < 2; j++) {
			for(int i = 0; i < nums.length; i++) {
				while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
					res[stack.pop()] = nums[i];
				}
				stack.push(i);
			}
		}
		
		return res;
		
		
    }
	
	public static void main(String[] args) {
		NextGreaterElementII test = new NextGreaterElementII();
		int[] nums = {1,2,1};
		test.nextGreaterElements(nums);
	}

}
