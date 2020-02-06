
public class MinimumFallingPathSumII {
	
	public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        int[] pre = new int[n];
        int[] cur;
        int min = Integer.MAX_VALUE;
        int min2nd = Integer.MAX_VALUE;
        
        for(int j = 0; j < n; j++) {
        	pre[j] = arr[0][j];
        	if(pre[j] < min) {
        		min2nd = min;
        		min = pre[j];
        	}else if(pre[j] < min2nd) {
        		min2nd = pre[j];
        	}
        }
        
        for(int i = 1; i < m; i++) {
        	cur = new int[n];
        	int curmin = Integer.MAX_VALUE;
            int curmin2nd = Integer.MAX_VALUE;
        	for(int j = 0; j < n; j++) {
        		if(pre[j] == min) {
        			cur[j] = arr[i][j] + min2nd;
        		}else {
        			cur[j] = arr[i][j] + min;
        		}
        		
        		
        		if(cur[j] < curmin) {
            		curmin2nd = curmin;
            		curmin = cur[j];
            	}else if(cur[j] < curmin2nd) {
            		curmin2nd = cur[j];
            	}
        		
        	}
        	
        	min = curmin;
        	min2nd = curmin2nd;
        	pre = cur;
        }
        
        min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
        	min = Math.min(min, pre[j]);
        }
        
        return min;
        
    }
	
	public static void main(String[] args) {
		MinimumFallingPathSumII test = new MinimumFallingPathSumII();
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(test.minFallingPathSum(arr));
	}
	
}
