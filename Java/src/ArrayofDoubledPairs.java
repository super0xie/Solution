import java.util.Arrays;
import java.util.HashMap;

public class ArrayofDoubledPairs {
	public boolean canReorderDoubled(int[] A) {
        
		Integer[] arr = new Integer[A.length];
		for(int i = 0; i < A.length; i++) {
			arr[i] = A[i];
		}
		
		Arrays.sort(arr, (a, b) -> {return Math.abs(a)-Math.abs(b);});
		
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr) {
        	map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int c = 0; c < arr.length; c++) {
        	int i = arr[c];
        	if(!map.containsKey(i)) continue;
        	
        	int count = map.get(i);
    		if(count == 1) map.remove(i);
    		else map.put(i, count-1);
        	
        	if(map.containsKey(2 * i)) {
        		count = map.get(i * 2);
        		if(count == 1) map.remove(2 * i);
        		else map.put(2 * i, count-1);
        	}else {
        		return false;
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,1,-8,8,-4,4,-4,2,-2};
		ArrayofDoubledPairs test = new ArrayofDoubledPairs();
		System.out.println(test.canReorderDoubled(A));
	}
}
