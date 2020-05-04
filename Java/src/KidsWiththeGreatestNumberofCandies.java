import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
	
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for(int i : candies) {
        	max = Math.max(max, i);
        }
        
        for(int i : candies) {
        	if(i + extraCandies >= max) res.add(true);
        	else res.add(false);
        }
        
        return res;
    }
}
