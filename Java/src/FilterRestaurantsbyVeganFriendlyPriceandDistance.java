import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterRestaurantsbyVeganFriendlyPriceandDistance {
	
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        
        
        List<int[]> cand = new ArrayList<>();
        for(int[] rest : restaurants) {
        	if(rest[3] <= maxPrice && rest[4] <= maxDistance && (veganFriendly == 0 || veganFriendly == rest[2])) {
        		cand.add(rest);
        	}
        }
        
        Collections.sort(cand, (a, b)->{
        	if(a[1] != b[1]) return b[1]-a[1];
        	else {
        		return b[0]-a[0];
        	}
        });
        
        for(int i = 0; i < cand.size(); i++) res.add(cand.get(i)[0]);
        
        return res;
    }
	
}
