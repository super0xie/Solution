public class PrimeArrangements{

    private int mod = 1000000007;

    public int numPrimeArrangements(int n) {
        int numOfP = countPrimes(n+1);
        int numOfC = n - numOfP;

        long res = helper(numOfP) * helper(numOfC);
        res = res % mod;
        return (int)res;
    }

    private long helper(long n){
        long res = 1;
        for(int i = 2; i <= n; i++){
            res = res * i;
            res = res % mod;
        }
        return res;
    }

    private int countPrimes(int n) {
		if(n <= 2)
			return 0;

		boolean[] dp = new boolean [n];
		int res = 0;
		for(int i = 2; i < n; i++){
			if(dp[i]) {
				continue;
			} else{
				res++;
				for(int j = 2; i * j < n; j++){
					dp[i*j] = true;
				}
			}
		}

        return res;
    }

    public static void main(String[] args) {
        PrimeArrangements test = new PrimeArrangements();
        System.out.println(test.numPrimeArrangements(100));
    }

}