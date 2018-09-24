
public class SmallestRangeI {
	
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num : A) {
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        
        int diff = max - min;
        if(diff > 2 * K) return diff - 2*K;
        else return 0;
    }
    
}
