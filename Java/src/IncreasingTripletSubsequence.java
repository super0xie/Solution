
public class IncreasingTripletSubsequence {
	
	public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        
        for(int num : nums) {
        	if(num <= min) {
        		min = num;
        	}
        	else if(num <= secMin) secMin = num;
        	else return true;
        }
        return false;
    }
	
	public static void main(String[] args) {		
		int[] nums = {1,0,0,0,0,0,10,0,0,10000};
	}

}
