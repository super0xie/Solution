
public class NumberofSubarraysWithOddSum {
	
	public int numOfSubarrays(int[] arr) {
		int mod = 1000000000 + 7;
        long sum = 0;
        int odd = 0;
        int even = 0;
        long res = 0;
        for(int i = 0; i < arr.length; i++) {
        	sum += arr[i];
        	if(sum % 2 == 1) {
        		res += even;
        		res++;
        		odd++;
        	} else {
        		res += odd;
        		even++;
        	}
        	res = res % mod;
        }
        
        return (int)res;
    }
	
	public static void main(String[] args) {
		NumberofSubarraysWithOddSum test = new NumberofSubarraysWithOddSum();
		int[] arr = {7};
		System.out.print(test.numOfSubarrays(arr));
		
	}
	
}
