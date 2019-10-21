import java.util.HashMap;
import java.util.TreeSet;

public class LongestArithmeticSubsequenceofGivenDifference {
	
	public int longestSubsequenceTLE(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        int res = 1;
        for(int i = 0; i < arr.length; i++) {
        	dp[i] = 1;
        	for(int j = i-1; j >= 0; j--) {
        		if(arr[i] - arr[j] == difference) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
	
	public int longestSubsequenceTLE2(int[] arr, int difference) {
        HashMap<Integer, TreeSet<Integer>> set = new HashMap<>();
        int res = 1;
        for(int i = 0; i < arr.length; i++) {
        	int len = 1;
        	int cur = i;
        	int n = arr[i];
        	while(set.containsKey(n-difference) && set.get(n-difference).floor(cur-1) != null) {
        		len++;
        		cur = set.get(n-difference).floor(cur-1);
        		n -= difference;
        	}
        	
        	res = Math.max(res, len);
        	
        	if(!set.containsKey(arr[i])) set.put(arr[i], new TreeSet<>());
        	set.get(arr[i]).add(i);
        }
        return res;
    }
	
	public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        
        int res = 1;
        for(int i = 0; i < arr.length; i++) {
        	int len = 1;
        	if(dp.containsKey(arr[i]-difference)) {
        		len = Math.max(len, dp.get(arr[i]-difference)+1);
        	}
        	
        	res = Math.max(res, len);
        	dp.put(arr[i], len);
        }
        return res;
    }
	
	public static void main(String[] args) {
		LongestArithmeticSubsequenceofGivenDifference test = new LongestArithmeticSubsequenceofGivenDifference();
		int[] arr = {1,3,5,7};
		System.out.println(test.longestSubsequence(arr, 1));
	}

}
