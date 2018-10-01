
public class CardGames {
	
	public boolean cardGamedp(int[] cards) {
		if(cards.length <= 3) return true;
		
		int[][] mem = new int[cards.length][2];
		mem[cards.length-1][0] = cards[cards.length-1];
		mem[cards.length-2][0] = cards[cards.length-1] + cards[cards.length-2];
		mem[cards.length-3][0] = cards[cards.length-1] + cards[cards.length-2] + cards[cards.length-3];
		mem[cards.length-1][1] = -mem[cards.length-1][0];
		mem[cards.length-2][1] = -mem[cards.length-2][0];
		mem[cards.length-3][1] = -mem[cards.length-3][0];
		
		for(int i = cards.length-4; i >=0; i--) {
			mem[i][0] = Math.max(Math.max(cards[i]+mem[i+1][1], cards[i] + cards[i+1] + mem[i+2][1])
					, cards[i] + cards[i+1] + cards[i+2] + mem[i+3][1]);
			mem[i][1] = Math.min(Math.min(-cards[i]+mem[i+1][0], -cards[i] - cards[i+1] + mem[i+2][0])
					, -cards[i] - cards[i+1] - cards[i+2] + mem[i+3][0]);
		}
		
		return mem[0][0] > 0;
	}
	
	public boolean cardGame(int[] cards) {
		if(cards.length <= 3) return true;
		
		int[] mem = new int[cards.length];
		int[] sums = new int[cards.length];
		
		int sum = 0;
		for(int i = cards.length-1; i >= 0; i--) {
			sum += cards[i];
			sums[i] = sum;
		}
		
		mem[cards.length-1] = sums[cards.length-1];
		mem[cards.length-2] = sums[cards.length-2];
		mem[cards.length-3] = sums[cards.length-3];
		
		for(int i = cards.length-4; i >= 0; i--) {
			mem[i] = Math.max(cards[i] + cards[i+1] + cards[i+2] + sums[i+3] - mem[i+3], Math.max(cards[i] + sums[i+1] - mem[i+1], cards[i] + cards[i+1] + sums[i+2] - mem[i+2]));
		}
		
		return mem[0] > sums[0] - mem[0];
	}
	
	public static void main(String[] args) {
		CardGames test = new CardGames();
		int[] cards = {5,7,2,4,9,6};
		System.out.println(test.cardGame(cards));
	}
	
	

}
