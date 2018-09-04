
public class MaximizeDistancetoClosestPerson {
	
	
	public int maxDistToClosest(int[] seats) {
		
		int i = 0;
		int ll = 0;
		int rl = 0;
		while(i < seats.length && seats[i] == 0) {
			i++;
			ll = i;
		}
		
		int j = seats.length-1;
		while(j >= 0 && seats[j] == 0) {
			j--;
			rl++;
		}
		
		int max = 0;
		int counter = 0;
		for(int ind = i ; ind <= j ; ind++) {
			if(seats[ind] == 0) {
				counter++;
				max = Math.max(max, counter);
			}else {
				counter = 0;
			}
		}
		
		int side = Math.max(ll, rl);
		
		return Math.max(side, (max+1)/2);
    }

}
