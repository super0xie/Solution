
public class GuessNumberHigherorLowerII {
	
    public int getMoneyAmount(int n) {
    	int [][] mem = new int[n+1][n+1];
    	
    	int result = helper(1, n, mem);
    	return result;
    }
    
    private int helper(int start, int end, int[][] mem) {
    	if(end - start == 0) return 0;
    	else if(end - start == 1) return start;
    	else if(end - start == 2) return start + 1;
    	else {
    		if(mem[start][end] != 0) return mem[start][end];
    		int result = Integer.MAX_VALUE;
    		for(int i = start; i <= end; i++) {
    			int other = 0;
    			if(i == start) {
    				other = i + helper(start + 1, end, mem);
    			}else if(i == end) {
    				other = i + helper(start, end-1, mem);
    			}else {
    				other = i + Math.max(helper(start, i-1, mem), helper(i+1, end, mem));
    			}
    			result = Math.min(result, other);
    		}
    		mem[start][end] = result;
    		return result;
    	}
    }
    
    public static void main(String[] args) {
    	GuessNumberHigherorLowerII test = new GuessNumberHigherorLowerII();
    	System.out.println(test.getMoneyAmount(6));
    }
    
    
}
