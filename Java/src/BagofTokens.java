import java.util.Arrays;

public class BagofTokens {
	
	
	
	public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int res = 0;
        int pow = P;
        int points = 0;
        while(i <= j) {
        	if(pow >= tokens[i]) {
        		pow -= tokens[i++];
        		points++;
        	}else if(points > 0){
        		pow += tokens[j--];
        		points--;
        	}else {
        		break;
        	}
        	res = Math.max(res, points);
        }
        return res;
    }
	
	public static void main(String[] args) {
		BagofTokens test = new BagofTokens();
		int[] tokens = {100,200,300,400};
		System.out.println(test.bagOfTokensScore(tokens, 200));
	}
	
}
