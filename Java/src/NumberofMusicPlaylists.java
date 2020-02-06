
public class NumberofMusicPlaylists {
	
	/*private static int mod = 1000000007;
	private long[][] choose;
	
	public int numMusicPlaylists(int N, int L, int K) {
		int[] cache = new int[N+1];
		choose = new long[N+1][N+1];
		int res = helper(N, L, K, cache);
		return res;
	}
	
	public int helper(int N, int L, int K, int[] cache) {
		if(N <= K) return 0;
		if(cache[N] > 0) return cache[N];
		
        long[] dp = new long[L];
        dp[0] = N;
        for(int i = 1; i < L; i++) {
        	dp[i] = dp[i-1] * N;
        	dp[i] = dp[i] % mod;
        	int len = Math.min(i, K);
        	dp[i] -= len * dp[i-1];
        	while(dp[i] < 0) dp[i] += mod;
        }
        
        long res = dp[L-1];
        for(int n = 0; n < N; n++) {
        	res -= helper(n, L, K, cache) * C(N, n);
        	while(res < 0) res += mod;
        	res = res % mod;
        }
        
        cache[N] = (int)res;
        return (int)res;
    }
	
	private long C(int m, int n) {
		if(n > m-n) n = m-n;
		
		if(choose[m][n] > 0) return choose[m][n];
		
		long upper = 1;
		boolean[] visited = new boolean[n+1];
		for(int i = m; m-i <= n-1; i--) {
			upper *= i;
			
			for(int j = 2; j <= n; j++) {
				if(visited[j] == true) continue;
				if(upper % j == 0) {
					upper = upper / j;
					visited[j] = true;
				}
			}
		}
		
		choose[m][n] = upper % mod;
		return choose[m][n];
	}*/
	
//	public int numMusicPlaylists(int N, int L, int K) {
//		int res = 0;
//		
//		return res;
//	}
//	
	
	private long C(int m, int n) {
		if(n > m-n) n = m-n;
		long upper = 1;
		for(int i = m; m-i <= n-1; i--) {
			upper *= i;
		}
		
		long lower = 1;
		for(int j = 2; j <= n; j++) {
			lower *= j;
		}
		
		return upper / lower;
	}

	
	
	
	
	
	public static void main(String[] args) {
		NumberofMusicPlaylists test = new NumberofMusicPlaylists();
//		System.out.println(test.numMusicPlaylists(37, 50, 8));
//		System.out.println((-1)%5);
		System.out.println(test.C(8, 4));
	}
	
}
