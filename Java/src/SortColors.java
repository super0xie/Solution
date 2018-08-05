
public class SortColors {
	
	public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int p = 0;
        
        while(p <= j) {
        	if(nums[p] < 1) {
        		swap(nums, i, p);
        		i++;
        		p++;
        	}else if(nums[p] > 1) {
        		swap(nums, j, p);
        		j--;
        	}else {
        		p++;
        	}
        }

    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int [] nums = {2,0,2,1,1,0};
		SortColors test = new SortColors();
		test.sortColors(nums);
	}

}
