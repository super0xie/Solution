import java.util.Arrays;

public class RotateArray {
	
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int [] aux = new int [nums.length];
        
        System.arraycopy(nums, nums.length-k, aux, 0, k);
        System.arraycopy(nums, 0, aux, k, nums.length-k);
        System.arraycopy(aux, 0, nums, 0, aux.length);
        
        
        
    }
}
