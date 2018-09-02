
public class ProductofArrayExceptSelf {
	
    public int[] productExceptSelf(int[] nums) {
        int [] ltr = new int[nums.length];
        int [] rtl = new int[nums.length];
        
        ltr[0] = nums[0];
        rtl[nums.length-1] = nums[nums.length-1];
        
        for(int i = 1; i < nums.length; i++) {
        	ltr[i] = ltr[i-1] * nums[i];
        }
        
        for(int i = nums.length-2; i >=0; i--) {
        	rtl[i] = rtl[i+1] * nums[i];
        }
        
        int[] res = new int[nums.length];
        res[0] = rtl[1];
        res[nums.length-1] = ltr[nums.length-2];
        for(int i = 1; i < nums.length-1; i++) {
        	res[i] = ltr[i-1] * rtl[i+1];
        }
        return res;
        
    }
    
}
