
public class PairsofSongsWithTotalDurationsDivisibleby60 {
	
	public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        
        for(int i : time) {
        	count[i % 60]++;
        }
        
        int res = count[0] * (count[0]-1) / 2;
        res += count[30] * (count[30]-1) / 2;
        
        for(int i = 1; i < 30; i++) {
        	res += count[i] * count[60-i];
        }
        
        return res;
        
    }
}
