import java.util.Arrays;

public class JumpGameV {
	
	public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        Integer[] indices = new Integer[n];
        
        for(int i = 0; i < n; i++) indices[i] = i;
        
        Arrays.parallelSort(indices, (a, b)->{
        	return arr[a]-arr[b];
        });
        
        int[] dp = new int[n];
        
        int res = 1;
        for(int i = 0; i < n; i++) {
        	int idx = indices[i];
        	int max = 0;
        	
        	
        	for(int j = idx-1; j >= Math.max(0, idx-d); j--) {
        		if(arr[j] >= arr[idx]) break;
        		max = Math.max(dp[j], max);
        	}
        	
        	for(int j = idx+1; j <= Math.min(n-1, idx+d); j++) {
        		if(arr[j] >= arr[idx]) break;
        		max = Math.max(dp[j], max);
        	}
        	
        	dp[idx] = max+1;
        	res = Math.max(dp[idx], res);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		JumpGameV test = new JumpGameV();
		int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
		System.out.print(test.maxJumps(arr, 2));
	}
	
}
