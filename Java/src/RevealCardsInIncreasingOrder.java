import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
	
	
	public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        return helper(deck, 0);
    }
	
	private int[] helper(int[] deck, int start) {
		int len = deck.length - start;
		if(len == 1) return new int[] {deck[start]};
		
		int[] res = new int[len];
		int idx = 0;
		int count = 0;
		int c = (len+1)/2;
		while(count < c) {
			res[idx] = deck[start+count];
			count++;
			idx += 2;
		}
		
		int[] ret = helper(deck, start + c);
		if(len % 2 == 0) {
			idx = 1;
			for(int i = 0; i < ret.length; i++) {
				res[idx] = ret[i];
				idx+=2;
			}
		}else {
			idx = 3;
			for(int i = 0; i < ret.length -1; i++) {
				res[idx] = ret[i];
				idx+=2;
			}
			res[1] = ret[ret.length-1];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		RevealCardsInIncreasingOrder test = new RevealCardsInIncreasingOrder();
		int[] deck = {17,13,11,2,3,5,7};
		int[] ret = test.deckRevealedIncreasing(deck);
		System.out.println("hello");
	}
	
	

}
