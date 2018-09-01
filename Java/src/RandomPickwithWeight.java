import java.util.Arrays;
import java.util.Random;

public class RandomPickwithWeight {
	
	private int[] nums;
	private int curr;
	private Random rand;
	public RandomPickwithWeight(int[] w) {
        nums = new int[w.length];
        curr = 0;
        for(int i = 0; i < w.length; i++) {
        	nums[i] = curr;
        	curr += w[i];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int r = rand.nextInt(curr);
        int index = Arrays.binarySearch(nums, r);
        if(index >= 0) return index;
        else {
        	index = -1-index;
        	return index-1;
        }
    }
    
    public static void main(String[] args) {
    	int [] w = {1,1,1};
    	RandomPickwithWeight test = new RandomPickwithWeight(w);
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    	System.out.println(test.pickIndex());
    }
}
