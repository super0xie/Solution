import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SteppingNumbers {
	
	private static ArrayList<Long> l = new ArrayList<>();
	
	static {
		l.add((long) 0);
		for(int len = 1; len < 11; len++) {
			for(int i = 1; i <= 9; i++) {
				helper(i, 1, len, 0, l);
			}
		}
		
	}
	
	public List<Integer> countSteppingNumbers(int low, int high) {
        int start = Collections.binarySearch(l, (long)low);
        if(start < 0) start = -start-1;
        
        int end = Collections.binarySearch(l, (long)high);
        if(end < 0) end = -end-1;
        else end = end + 1;
        
        List<Integer> res = new ArrayList<>();
        for(int i = start; i < end; i++) res.add((int)((long)l.get(i)));
        return res;
        
        
    }
	
	
	private static void helper(int i, int count, int len, long n, ArrayList<Long> list) {
		if(i > 9 || i < 0) return;
		n = n * 10 + i;
		if(count == len) {
			list.add(n);
			return;
		}
		
		helper(i-1, count+1, len, n, list);
		helper(i+1, count+1, len, n, list);
	}
	
	public static void main(String[] args) {
		SteppingNumbers test = new SteppingNumbers();
//		ArrayList<Long> l = new ArrayList<>();
//		for(int len = 1; len < 11; len++) {
//			for(int i = 1; i <= 9; i++) {
//				SteppingNumbers.helper(i, 1, len, 0, l);
//			}
//		}
//		
//		for(long i : l) System.out.print(i + ", ");
		
		List<Integer> l = test.countSteppingNumbers(11, 20);
		for(long i : l) System.out.print(i + ", ");
		
		
		
	}
	
	
	
	
	
	
}
