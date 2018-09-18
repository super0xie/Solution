
public class RemoveDuplicatesfromSortedArrayII {
	
	public int removeDuplicates1(int[] nums) {
        int i = 0;
        for(int num : nums) {
        	if(i < 2 || num != nums[i-2])
        		nums[i++] = num;
        }
        return i;
    }
	
	
	public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        
        while(j < nums.length-1) {
        	while(j < nums.length-1 && nums[j] == nums[j+1]) j++;
        	nums[i++] = nums[j];
        	j++;
        }
        
        if(nums.length > 2 &&  nums[nums.length-1] != nums[nums.length-2]) nums[i++] = nums[j];
        
        return i;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		RemoveDuplicatesfromSortedArrayII test = new RemoveDuplicatesfromSortedArrayII();
		test.removeDuplicates(nums);
		
	}

}
