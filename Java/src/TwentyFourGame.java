
public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        
        double [] doubles = new double[4];
        for(int i = 0; i < nums.length; i++) {
        	doubles[i] = (double)nums[i];
        }
        return dfs(doubles, 4);
    }
    
    private boolean dfs(double[] nums, int left) {
    	
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = 0; j < nums.length; j++) {
    			if(i == j) continue;
    			if(nums[i] == Double.MIN_VALUE || nums[j] == Double.MIN_VALUE) continue;
    			double savedI = nums[i];
    			double savedJ = nums[j];
    			
    			for(int k = 0; k < 4; k++) {
    				double res;
    				if(k == 0) res = nums[i] + nums[j];
    				else if(k == 1) res = nums[i] - nums[j];
    				else if(k == 2) res = nums[i] * nums[j];
    				else {
    					if(nums[j] == 0) continue;
    					else res = nums[i] / nums[j];
    				}
        			
        			if(left == 2) {
        				if(Math.abs(res - 24) < 0.01) return true;
        			}else if(left > 2){
        				nums[i] = Double.MIN_VALUE;
        				nums[j] = res;
        				if(dfs(nums, left-1)) return true;
        				nums[i] = savedI;
        				nums[j] = savedJ;
        			}
    			}
    			
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 3, 4, 6};
    	TwentyFourGame test = new TwentyFourGame();
    	System.out.println(test.judgePoint24(nums));
    	
//    	System.out.println(Double.isNaN(v));
    }
}
