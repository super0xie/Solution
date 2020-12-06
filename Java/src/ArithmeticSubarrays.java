import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticSubarrays {
	
	
	
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<>();
		int m = l.length;
		for(int i = 0; i < m; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = l[i]; j <= r[i]; j++) {
				list.add(nums[j]);
			}
			Collections.sort(list);
			int j = 2;
			int diff = list.get(1)-list.get(0);
			for(; j < list.size(); j++) {
				if(list.get(j)-list.get(j-1) != diff) break;
			}
			if(j == list.size()) res.add(true);
			else res.add(false);
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArithmeticSubarrays test = new ArithmeticSubarrays();
		int[] nums = {4,6,5,9,3,7};
		int[] l = {0,0,2};
		int[] r = {2,3,5};
		test.checkArithmeticSubarrays(nums, l, r);
	}
	
	
}
