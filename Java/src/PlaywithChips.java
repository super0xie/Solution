
public class PlaywithChips {
	
	public int minCostToMoveChips(int[] chips) {
		int a = 0;
		int b = 0;
		for(int i : chips) {
			if(i % 2 == 0) a++;
			else b++;
		}
		return Math.min(a, b);
    }

}
