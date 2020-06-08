import java.util.ArrayList;

public class ProbabilityofaTwoBoxesHavingTheSameNumberofDistinctBalls {
	
	private int[] fac = {1, 1, 2, 6, 24, 120, 720};
	private double aux = 0;
	public double getProbability(int[] balls) {
		int sum = 0;
		for(int i : balls) sum += i;
		double total = 1;
		for(int i = 1; i <= sum; i++) total *= i;
		for(int i : balls) total /= fac[i];
		
		int tar = sum / 2;
		aux = fac(tar);
		aux = aux * aux;
		int[] a = new int[balls.length];
		int[] b = new int[balls.length];
		
		double valid = dfs(0, balls, a, b, 0, 0, tar, 0, 0);
		return valid / total;
    }
	
	
	private double dfs(int i, int[] balls, int[] a, int[] b, int sa, int sb, int tar, int ca, int cb) {
		double res = 0;
		
		for(int n = 0; n <= balls[i]; n++) {
			a[i] = n;
			b[i] = balls[i]-n;
			int nca = ca;
			if(a[i] > 0) nca++;
			int ncb = cb;
			if(b[i] > 0) ncb++;
			
			int nsa = sa + a[i];
			int nsb = sb + b[i];
			
			if(nsa > tar || nsb > tar) continue;
			
			if(i == balls.length-1) {
				if(nsa != nsb || nca != ncb) continue;
				double cur = aux;
				for(int c : a) 
					if(c > 1) cur = cur / fac[c];
				for(int c : b)
					if(c > 1) cur = cur / fac[c];
				
				return cur;
			}else {
				res += dfs(i+1, balls, a, b, nsa, nsb, tar, nca, ncb);
			}
			
		}
		return res;
	}
	
	private double fac(int n) {
		double res = 1;
		for(int i = 1; i <= n; i++) res *= i;
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		ProbabilityofaTwoBoxesHavingTheSameNumberofDistinctBalls test = new ProbabilityofaTwoBoxesHavingTheSameNumberofDistinctBalls();
		System.out.println(test.getProbability(new int [] {6,6,6,6,6,6}));
	}
	
	
	
	
}
