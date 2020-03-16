import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofThreeSortedArrays {
	
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++) {
        	int n = arr1[i];
        	if(Arrays.binarySearch(arr2, n) >= 0 && Arrays.binarySearch(arr3, n) >= 0) res.add(n);
        }
        return res;
    }
	
}
