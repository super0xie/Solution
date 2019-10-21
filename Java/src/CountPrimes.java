

public class CountPrimes {
	
	public int countPrimesOld(int n) {
		
		if(n <= 3)
			return 0;
        
		int counter = 1;
        
        for(int i = 3 ; i < n; i=i+2) {
        	if(isPrime(i)) counter++;
        }
        
        return counter;
	}
	
	public int countPrimes(int n) {
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
	
	private boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(6));
	}

}
