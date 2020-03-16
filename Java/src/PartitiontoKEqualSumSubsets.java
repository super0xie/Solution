import java.util.HashSet;

public class PartitiontoKEqualSumSubsets {
	
	public boolean canPartitionKSubsetsOld(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) {
        	sum += i;
        }
        
        if(sum % k != 0) return false;
        int target = sum / k;
        boolean [] used = new boolean[nums.length];
        HashSet<Integer> set = new HashSet<>();
        
        return dfs(used, nums, 0, 0, target, set);
    }
	
	private boolean dfs(boolean[] used, int[] nums, int cur, int count, int target, HashSet<Integer> set) {
		int encode = encode(used);
		if(set.contains(encode)) return false;
		if(count == nums.length) return true;
		
		for(int i = 0; i < nums.length; i++) {
			if(used[i]) continue;
			int sum = cur+nums[i];
			if(sum <= target) {
				used[i] = true;
				if(dfs(used, nums, sum % target, count+1, target, set)) return true;
				used[i] = false;
			}
		}
		set.add(encode);
		
		return false;
	}
	
	private int encode(boolean[] used) {
		int res = 0;
		for(boolean b : used) {
			if(b) res += 1;
			res = res << 1;
		}
		return res;
	}
	
	private int used = 0;
	private int[] a = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
	private int[] b = {65534, 65533, 65531, 65527, 65519, 65503, 65471, 65407, 65279, 65023, 64511, 63487, 61439, 57343, 49151, 32767};
	
	private boolean get(int i) {
		return (used & a[i]) > 0;
	}
	
	private void set(int i, boolean tf) {
		if(tf) {
			used = used | a[i];
		} else {
			used = used & b[i];
		}
	}
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) {
        	sum += i;
        }
        
        if(sum % k != 0) return false;
        int target = sum / k;
        used = 0;
        
        boolean[] memo = new boolean[1 << nums.length];
        
        return dfs(nums, 0, 0, target, memo);
    }
	
	private boolean dfs(int[] nums, int cur, int count, int target, boolean[] set) {
		if(set[used]) return false;
		if(count == nums.length) return true;
		
		for(int i = 0; i < nums.length; i++) {
			if(get(i)) continue;
			int sum = cur+nums[i];
			if(sum <= target) {
				set(i, true);
				if(dfs(nums, sum % target, count+1, target, set)) return true;
				set(i, false);
			}
		}
		set[used] = true;
		return false;
	}
	
	public static void main(String[] args) {
		PartitiontoKEqualSumSubsets test = new PartitiontoKEqualSumSubsets();
		int[] nums = {129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22};
		System.out.println(test.canPartitionKSubsets(nums, 3));
		
//		int[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
//		for(int i = 0; i < 16; i++) {
//			System.out.print((~arr[i] & 0b1111111111111111) + ", ");
			
//			System.out.print(Integer.toBinaryString(~arr[i] & 0b1111111111111111) + ", ");
//		}
	}
}
