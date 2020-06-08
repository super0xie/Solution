
public class ShuffletheArray {
	
	public int[] shuffle(int[] nums, int n) {
		assert(nums.length == 2 * n);
        int[] res = new int[nums.length];
        int a = 0;
        int b = n;
        for(int i = 0; i < 2*n; i++) {
        	res[i++] = nums[a++];
        	res[i] = nums[b++];
        }
        
        return res;
    }
	
}
