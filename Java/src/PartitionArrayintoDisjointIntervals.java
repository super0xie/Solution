import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionArrayintoDisjointIntervals {
	
	public int partitionDisjoint(int[] A) {
		int lmax = Integer.MIN_VALUE;
		
		int[] max = new int[A.length];
		for(int i = 0; i < A.length; i++) {
			lmax = Math.max(lmax, A[i]);
			max[i] = lmax;
		}
		
		int rmin = Integer.MAX_VALUE;
		int[] min = new int[A.length];
		
		for(int i = A.length-1; i >= 0; i--) {
			rmin = Math.min(rmin, A[i]);
			min[i] = rmin;
		}
		
		for(int i = 0; i < A.length-1; i++) {
			if(max[i] <= min[i+1]) return i+1;
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		PartitionArrayintoDisjointIntervals test = new PartitionArrayintoDisjointIntervals();
		int[] A = {1,1,1,0,6,12};
		System.out.println(test.partitionDisjoint(A));
	}
}
