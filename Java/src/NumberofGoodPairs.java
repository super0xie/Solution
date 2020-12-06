
public class NumberofGoodPairs {
	
	public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for(int i : nums) {
        	count[i]++;
        }
        int res = 0;
        for(int i : count) {
        	if(i >= 2) {
        		res += i * (i-1) / 2;
        	}
        }
        return res;
    }
	
}
