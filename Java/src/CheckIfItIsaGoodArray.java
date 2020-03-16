import java.util.Arrays;

public class CheckIfItIsaGoodArray {
	
	public boolean isGoodArray(int[] nums) {
		if(nums.length == 1 && (nums[0]== 1 || nums[0]== -1)) return true;
        
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	cur = gcd(nums[i], cur);
        	if(cur == 1) return true;
        }
        
        return false;
    }
	
	private int gcd(int a, int b) {
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void main(String[] args) {
		CheckIfItIsaGoodArray test = new CheckIfItIsaGoodArray();
		int[] nums = {3,6};
		System.out.println(test.isGoodArray(nums));
	}
}
