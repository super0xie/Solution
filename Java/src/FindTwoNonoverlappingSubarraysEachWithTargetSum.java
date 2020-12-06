import java.util.ArrayList;
import java.util.HashMap;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
	
	public int minSumOfLengths(int[] arr, int target) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] mindp = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
        	sum += arr[i];
        	map.put(sum, i);
        	int pre = sum - target;
        	if(map.containsKey(pre)) {
        		int idx = map.get(pre);
        		min = Math.min(min, i-idx);
        		if(idx != -1 && mindp[idx] != Integer.MAX_VALUE)
        			res = Math.min(res, i-idx + mindp[idx]);
        	}
        	mindp[i] = min;
        }
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
	
	public static void main(String[] args) {
		FindTwoNonoverlappingSubarraysEachWithTargetSum test = new FindTwoNonoverlappingSubarraysEachWithTargetSum();
		int[] arr = {3,1,1,1,5,1,2,1};
		System.out.println(test.minSumOfLengths(arr, 3));
	}
}
