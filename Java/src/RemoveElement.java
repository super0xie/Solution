
public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0)
			return 0;
		int i = 0;
		int j = nums.length - 1;
		while(i < j) {
			if(nums[j] == val) {
				j--;
			}
			else if(nums[i] == val) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
			else {
				i++;
			}
		}
		
		if(nums[i] == val) return i;
		else return i+1;
    }
	
	public static void main(String[] args) {
		RemoveElement test = new RemoveElement();
		int [] nums = {3,2,2,3};
		System.out.println(test.removeElement(nums, 3));
		
	}
}
