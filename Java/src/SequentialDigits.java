import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequentialDigits {

//	ArrayList<Integer> l = new ArrayList<>();
//	
//	private void dfs(int i, int idx, int len, int n) {
//		if(idx == len) l.add(n);
//		else {
//			if(i == 10) return;
//			n = n * 10;
//			n += i;
//			dfs(i+1, idx+1, len, n);
//		}
//	}
	
	
	private int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
	
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		
		int l = Arrays.binarySearch(nums, low);
		if(l < 0) l = -1-l;
		
		int r = Arrays.binarySearch(nums, high);
		if(r < 0) {
			r = -1-r-1;
		}
		
		for(int i = l; i <= r; i++) {
			res.add(nums[i]);
		}
		
		return res;

    }
	
	public static void main(String[] args) {
		SequentialDigits test = new SequentialDigits();
//		for(int i = 1; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				test.dfs(j, 0, i, 0);
//			}
//		}
//		
//		for(int i : test.l) {
//			System.out.print(i + ", ");
//		}
		
		List<Integer> res = test.sequentialDigits(57, 66);
		for(int i : res) System.out.println(i);
		
	}
}
