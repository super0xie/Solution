import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionforaGivenEquation {
	
	interface CustomFunction {
		public int f(int x, int y);
	}
	
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> res = new ArrayList<>();
		
		for(int i = 1; i <= 1000; i++) {
			
			int l = 1;
			int r = 1000;
			
			while(l <= r) {
				int mid = l + (r-l)/2;
				int ret = customfunction.f(i, mid);
				if(ret == z) {
					res.add(Arrays.asList(i, mid));
					break;
				}else if(ret < z){
					l = mid+1;
				}else {
					r = mid-1;
				}
			}
			
		}
		
		return res;
    }
}
