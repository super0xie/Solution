
public class NextPermutation {
	
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1) return;
		
		int firstDecreaseIndex = -1;
		for(int i = nums.length - 2; i >= 0; i--) {
			if(nums[i] < nums[i+1]) {
				firstDecreaseIndex = i;
				break;
			}
		}
		
		if(firstDecreaseIndex < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		
		int indexToSwap = -1;
		for(int i = nums.length - 1; i >=0; i--) {
			if(nums[i] > nums[firstDecreaseIndex]) {
				indexToSwap = i;
				break;
			}
		}
		
		swap(nums, firstDecreaseIndex, indexToSwap);
		
		reverse(nums, firstDecreaseIndex+1, nums.length-1);
		
		
        
    }
	
	
	private void reverse(int [] nums, int start, int end) {
		while(start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int [] nums = {1, 2, 5, 4, 3, 1};
		np.nextPermutation(nums);
		System.out.println("test");
	}

}
