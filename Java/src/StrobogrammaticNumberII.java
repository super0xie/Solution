import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
	
	public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0) return res;
        char[][] pairs = new char [][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        dfs(0, "", "", n, res, pairs);
        return res;
    }
	
	private void dfs(int ind, String l, String r, int n, List<String> res, char[][] pairs) {
		if(n % 2 == 1 && ind == n/2) {
			res.add(l+"0"+r);
			res.add(l+"1"+r);
			res.add(l+"8"+r);
			return;
		}
		
		int start = 0;
		if(ind == 0) start = 1;
		
		for(int i = start; i < pairs.length; i++) {
			if(ind == (n-1) / 2)
				res.add(l+pairs[i][0] + pairs[i][1] + r);
			else
				dfs(ind+1, l+pairs[i][0], pairs[i][1] + r, n, res, pairs);
		}
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumberII test = new StrobogrammaticNumberII();
		test.findStrobogrammatic(10);
	}

}
