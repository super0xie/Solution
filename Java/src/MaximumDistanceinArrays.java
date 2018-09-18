import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceinArrays {
    
    public int maxDistance(List<List<Integer>> arrays) {
        
        int [] maxArray = new int [arrays.size()];
        int [] minArray = new int [arrays.size()];
        int idx = 0;
        for(List<Integer> list : arrays) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int num : list) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            
            
            
            maxArray[idx] = max;
            minArray[idx++] = min;
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < maxArray.length; i++) {
            for(int j = i+1; j < maxArray.length; j++) {
                res = Math.max(res, Math.max(Math.abs(maxArray[i]-minArray[j]), Math.abs(maxArray[j]-minArray[i])));
                
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        arrays.add(Arrays.asList(1,2,3));
        arrays.add(Arrays.asList(4,5));
        arrays.add(Arrays.asList(1,2,3));
        MaximumDistanceinArrays test = new MaximumDistanceinArrays();
        test.maxDistance(arrays);
    }
    
}
