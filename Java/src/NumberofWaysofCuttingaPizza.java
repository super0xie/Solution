
public class NumberofWaysofCuttingaPizza {
	
	public int ways(String[] pizza, int p) {
		int m = pizza.length;
		int n = pizza[0].length();
		int mod = 1000000007;
        int[][] prefix = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(j > 0) prefix[i][j] += prefix[i][j-1];
        		if(pizza[i].charAt(j) == 'A') prefix[i][j] += 1;
        	}
        }
        
        for(int j = 0; j < n; j++) {
        	for(int i = 0; i < m; i++) {
        		if(i > 0) prefix[i][j] += prefix[i-1][j];
        	}
        }
        
        long[][][] dp = new long[m][n][p];
        
        for(int i = m-1; i >= 0; i--) {
        	for(int j = n-1; j >= 0; j--) {
        		for(int k = 0; k < p; k++) {
        			if(k == 0) {
        				if(numOfApple(prefix, i, j, m-1, n-1) > 0) {
        					dp[i][j][k] = 1;
        				}else {
        					dp[i][j][k] = 0;
        				}
        			}else {
        				for(int ii = i+1; ii < m; ii++) {
        					if(numOfApple(prefix, i, j, ii-1, n-1) > 0 
        							&& numOfApple(prefix, ii, j, m-1, n-1) > 0) {
        						dp[i][j][k] += dp[ii][j][k-1];
        						dp[i][j][k] = dp[i][j][k] % mod;
        					}
        						
        				}
        				
        				for(int jj = j+1; jj < n; jj++) {
        					if(numOfApple(prefix, i, j, m-1, jj-1) > 0 
                					&& numOfApple(prefix, i, jj, m-1, n-1) > 0) {
        						dp[i][j][k] += dp[i][jj][k-1];
        						dp[i][j][k] = dp[i][j][k] % mod;
        					}
                						
        				}
        			}
        		}
        	}
        }
        
        return (int)dp[0][0][p-1];
    }
	
	private int numOfApple(int[][] prefix, int tli, int tlj, int bri, int brj) {
		int res = prefix[bri][brj];
		if(tli > 0) res -= prefix[tli-1][brj];
		if(tlj > 0) res -= prefix[bri][tlj-1];
		if(tli >0 && tlj > 0) res += prefix[tli-1][tlj-1];
		return res;
	}
	
	public static void main(String[] args) {
		NumberofWaysofCuttingaPizza test = new NumberofWaysofCuttingaPizza();
		System.out.println(test.ways(new String[] {"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA","A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.","A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA","....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.","AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..","....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA","A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A",".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.","A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..","A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.",".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....","..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.","...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A","A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...","A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA","AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A","...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA","..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A","AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A","A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...","..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.",".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A",".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..","A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..","A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA",".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA","A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....","A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..",".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.","A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...","AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..","A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....","A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..",".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA","..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..","AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA","..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........",".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A","AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..",".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA","AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.","......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.","AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.",".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA",".AA.A...AA.AAA.A....A.A...A........A.AAA......A...","..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..","..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A",".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.","...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.","..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"}, 8));
	}
	
}
