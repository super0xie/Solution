import java.util.ArrayList;
import java.util.Collections;

public class RangeSumofSortedSubarraySums {
	
	public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	int sum = 0;
        	for(int j = i; j < nums.length; j++) {
        		sum += nums[j];
        		l.add(sum);
        	}
        }
        
        Collections.sort(l);
        
        int res = 0;
        int mod = 1000000000+7;
        
        for(int i = left-1; i <= right-1; i++) {
        	res += l.get(i);
        	res = res % mod;
        }
        
        return res;
    }
	
}
