
public class MinimumOperationstoMakeArrayEqual {
	
	public int minOperations(int n) {
		if(n == 1) return 0;
        int sum = (1 + 2 * (n-1) + 1) * n / 2;
        int target = sum / n;
        
        
        if(n % 2 == 1) {
        	int count = (n+1)/2;
        	int res = (target-1) * count / 2;
        	return res;
        } else {
        	int count = n / 2;
        	int res = target * count / 2;
        	return res;
        }
        
    }
	
	public static void main(String[] args) {
		MinimumOperationstoMakeArrayEqual test = new MinimumOperationstoMakeArrayEqual();
		System.out.println(test.minOperations(6));
	}
	
}
