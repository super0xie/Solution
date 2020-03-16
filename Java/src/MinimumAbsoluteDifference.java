import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
        	min = Math.min(min, arr[i]-arr[i-1]);
        }
        
        for(int i = 1; i < arr.length; i++) {
        	if(arr[i]-arr[i-1] == min) {
        		res.add(Arrays.asList(arr[i-1], arr[i]));
        	}
        }
        return res;
    }
	
}
