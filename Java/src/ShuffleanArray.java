import java.util.Random;

public class ShuffleanArray {
	private int[] origin;
	public void Solution(int[] nums) {
		origin = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] aux = new int[origin.length];
        
        for(int i = 0; i < origin.length; i++) {
        	aux[i] = origin[i];
        }
        
        Random r = new Random();
        for(int i = origin.length-1; i >= 0; i--) {
        	int idx = r.nextInt(i+1);
        	int temp = aux[idx];
        	aux[idx] = aux[i];
        	aux[i] = temp;
        }
        
        return aux;
    }

}
