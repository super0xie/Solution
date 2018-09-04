
public class KthLargestElementinanArray {
	
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start;
		
		for(int j = start; j <= end-1; j++) {
			if(nums[j] < pivot) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		
		int temp = nums[i];
		nums[i] = nums[end];
		nums[end] = temp;
		
		return i;
	}
	
	
	public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
        	int i = partition(nums, start, end);
        	
        	if(i == target) return nums[i];
        	if(i > target) end = i - 1;
        	else start = i + 1;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		KthLargestElementinanArray test = new KthLargestElementinanArray();
		int[] nums = {1};
		System.out.println(test.findKthLargest(nums, 1));
		
	}
}
