import java.util.Arrays;

public class RelativeRanks {
	
	public String[] findRelativeRanks(int[] nums) {
        Integer [] rank = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	rank[i] = i;
        }
        Arrays.sort(rank, (a,b)->{return nums[b]-nums[a];});
        
        String[] res = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	if(i == 0) res[rank[i]] = "Gold Medal";
        	else if(i == 1) res[rank[i]] = "Silver Medal";
        	else if(i == 2) res[rank[i]] = "Bronze Medal";
        	else{
        		res[rank[i]] = (i+1)+"";
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		RelativeRanks test = new RelativeRanks();
		int[] nums = {10,3,8,9,4};
		test.findRelativeRanks(nums);
	}
	

}
