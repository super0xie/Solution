import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {
	private static int mod = 1000000000+7;
	private static int[] aux = new int[100000];
	
	static {
		int cur = 1;
		for(int i = 0; i < aux.length; i++) {
			aux[i] = cur;
			cur = cur * 2;
			cur = cur % mod;
		}
	}
	
	public int numSubseq(int[] nums, int target) {
		
        Arrays.parallelSort(nums);
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] * 2 > target) break;
        	int other = target - nums[i];
        	int r = Arrays.binarySearch(nums, other);
        	if(r < 0) r = -r-2;
        	else {
        		while(r+1 < nums.length && nums[r+1] == nums[r]) r++;
        	}
        	
        	int n = r - i;
        	res += aux[n];
        	res = res % mod;
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		NumberofSubsequencesThatSatisfytheGivenSumCondition test = new NumberofSubsequencesThatSatisfytheGivenSumCondition();
		int[] nums = {3,5,6,7};
		test.numSubseq(nums, 9);
	}
	
}
