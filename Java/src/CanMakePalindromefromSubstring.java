import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromefromSubstring {
	
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> res = new ArrayList<>();
		int[][] count = new int[s.length()][26];
		count[0][s.charAt(0)-'a']++;
		
		for(int i = 1; i < s.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(j == s.charAt(i)-'a') count[i][j] = count[i-1][j]+1;
				else count[i][j] = count[i-1][j];
			}
		}
        for(int[] q : queries) {
        	int l = q[0];
        	int r = q[1];
        	int k = q[2];
        	
        	int odd = 0;
        	for(int i = 0; i < 26; i++) if(helper(count, l, r, i) % 2 == 1) odd++;
        	
        	int n = odd / 2;
        	if(n > k) res.add(false);
        	else res.add(true);
        }
        
        return res;
    }
	
	private int helper(int[][] count, int l, int r, int i) {
		if(l == 0) return count[r][i];
		else return count[r][i] - count[l-1][i];
	}
	
	public static void main(String[] args) {
		CanMakePalindromefromSubstring test = new CanMakePalindromefromSubstring();
		int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
		List<Boolean> res = test.canMakePaliQueries("abcda", queries);
		for(boolean b : res) System.out.print(b + ", ");
	}
	
}
