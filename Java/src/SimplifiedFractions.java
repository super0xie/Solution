import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
	
	public List<String> simplifiedFractions(int n) {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
        	for(int j = 1; j < i; j++) {
        		if(gcd(i, j) == 1) res.add(j + "/" + i);
        	}
        }
        return res;
    }
	
	private int gcd(int a, int b) {
		while(b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
