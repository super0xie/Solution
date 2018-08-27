import java.util.HashMap;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < B.length; i++) {
        	map.put(B[i], i);
        }
        
        int[] result = new int [A.length];
        
        for(int i = 0; i < A.length; i++) {
        	result[i] = map.get(A[i]);
        }
        
        return result;
    }
}
