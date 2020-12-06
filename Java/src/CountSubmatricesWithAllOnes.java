
public class CountSubmatricesWithAllOnes {
	private int[][] prefix;
	
	public int numSubmatOld(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        prefix = new int[m][n];

        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += mat[i][j];
                prefix[i][j] = sum;
            }
        }

        for(int j = 0; j < n; j++){
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }
        
        for(int i = 0; i < m; i++) {
        	int count = 0;
        	for(int j = 0; j < n; j++) {
        		if(mat[i][j] == 1) {
        			count++;
        			for(int k = j; k >= j-count+1; k--) {
        				for(int l = i; l >= 0; l--) {
        					int w = j-k+1;
        					int h = i-l+1;
        					if(sum(l, k, i, j) == w * h) {
        						res++;
        					}else {
        						break;
        					}
        				}
        			}
        		} else {
        			count = 0;
        		}
        	}
        }
        return res;
    }
	
	public int sum(int row1, int col1, int row2, int col2) {
        int res = prefix[row2][col2];
        if(row1 > 0) res -= prefix[row1-1][col2];
        if(col1 > 0) res -= prefix[row2][col1-1];
        if(row1 > 0 && col1 > 0) res += prefix[row1-1][col1-1];
        return res;
    }
	
	public int numSubmat(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m][n][m];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(mat[i][j] == 1) {
        			int sum = 0;
        			for(int k = i; k >= 0; k--) {
        				if(mat[k][j] == 1) {
        					res++;
        					dp[i][j][k] = 1;
        					if(j > 0) {
        						dp[i][j][k] += dp[i][j-1][k];
        						res += dp[i][j-1][k];
        					}
        				}else {
        					break;
        				}
        			}
        		}
        	}
        }
        
        return res;
    }
	
	
	
	
	public static void main(String[] args) {
		int[][] mat = {{1,1,1,1,1,1}};
		CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
		System.out.println(test.numSubmat(mat));
	}
	
}
