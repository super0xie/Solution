import java.util.ArrayList;

public class CountNumberofNiceSubarrays {
	
	public int numberOfSubarrays(int[] nums, int k) {
		ArrayList<Integer> indices = new ArrayList<>();
		int res = 0;
		indices.add(-1);
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 2 == 1) indices.add(i);
		}
		indices.add(nums.length);
		
		for(int i = 1; i + k - 1 < indices.size()-1; i++) {
			int l = indices.get(i)-indices.get(i-1);
			int r = indices.get(i+k)-indices.get(i+k-1);
			res += l * r;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		CountNumberofNiceSubarrays test = new CountNumberofNiceSubarrays();
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		System.out.println(test.numberOfSubarrays(nums, 2));
	}
	
}
