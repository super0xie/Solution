import java.util.TreeMap;

public class PreviousPermutationWithOneSwap {
	public int[] prevPermOpt1(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = A.length-1; i >= 0; i--) {
        	Integer floor = map.floorKey(A[i]-1);
        	if(floor == null) map.put(A[i], i);
        	else {
        		int idx = map.get(floor);
        		int tmp = A[i];
        		A[i] = A[idx];
        		A[idx] = tmp;
        		break;
        	}
        }
        
        return A;
    }
	
	public static void main(String[] args) {
		PreviousPermutationWithOneSwap test = new PreviousPermutationWithOneSwap();
		int[] A = {1,1,5};
		test.prevPermOpt1(A);
		for(int i : A) System.out.print(i + ", ");
	}
	
}
