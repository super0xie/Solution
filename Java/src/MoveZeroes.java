
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
    	int cur = 0;
    	int index = 0;
    	
    	
    	while(cur < nums.length) {
    		while(cur < nums.length && nums[cur] == 0) cur++;
    		if(cur < nums.length) nums[index++] = nums[cur++];
    	}
    	
    	while(index < nums.length) nums[index++] = 0;
    }
    
    public static void main(String[] args) {
    	int[] nums = {0};
    	MoveZeroes test = new MoveZeroes();
    	test.moveZeroes(nums);
    }
}
