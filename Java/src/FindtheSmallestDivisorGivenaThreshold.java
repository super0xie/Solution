
public class FindtheSmallestDivisorGivenaThreshold {

	public int smallestDivisor(int[] nums, int threshold) {
        float[] arr = new float[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	arr[i] = nums[i];
        }
        
        int a = 1;
        int b = 1000000;
        
        while(a < b) {
        	int mid = a + (b-a)/2;
        	if(valid(arr, mid, threshold)) b = mid;
        	else a = mid + 1;
        }
        
        return a;
    }
	
	private boolean valid(float[] nums, int div, int thres) {
		int sum = 0;
		for(float f : nums) {
			float res = f / div;
			if(res == (int)res) sum += res;
			else sum += (int)res + 1;
		}
		
		if(sum <= thres) return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		FindtheSmallestDivisorGivenaThreshold test = new FindtheSmallestDivisorGivenaThreshold();
		int[] nums = {19};
		System.out.println(test.smallestDivisor(nums, 5));
		
	}
	
	
	
}
