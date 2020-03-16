
public class DistributeCandiestoPeople {

	public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int round = 0;
        while(candies > 0) {
        	for(int i = 0; i < res.length; i++) {
        		int toGive = round * num_people + i + 1;
        		if(candies >= toGive) {
        			res[i] += toGive;
        			candies -= toGive;
        		}else {
        			res[i] += candies;
        			candies = 0;
        		}
        		
        		if(candies == 0) break;
        	}
        	round++;
        }
        
        return res;
    }
	
}
