
public class MaximumScoreAfterSplittingaString {
	
	public int maxScore(String s) {
        int totalOne = 0;
        for(int i = 0; i < s.length(); i++) 
        	if(s.charAt(i) == '1') totalOne++;
        
        int zeros = 0;
        int ones = 0;
        int max = 0;
        for(int i = 0; i < s.length()-1; i++) {
        	if(s.charAt(i) == '0') zeros++;
        	else ones++;
        	
        	int score = zeros + totalOne - ones;
        	max = Math.max(max, score);
        }
        
        return max;
    }
	
}
