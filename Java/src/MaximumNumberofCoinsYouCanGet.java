import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {
	public int maxCoins(int[] piles) {
        Arrays.parallelSort(piles);
        int res = 0;
        int r = 0;
        for(int i = piles.length-2; i > r; i-=2, r++) 
        	res += piles[i];
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] piles = {9,8,7,6,5,1,2,3,4};
		MaximumNumberofCoinsYouCanGet test = new MaximumNumberofCoinsYouCanGet();
		System.out.println(test.maxCoins(piles));
	}
}
