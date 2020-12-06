
public class SumofAllOddLengthSubarrays {
	
	public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for(int len = 1; len <= arr.length; len += 2) {
        	int sum = 0;
        	for(int i = 0; i < arr.length; i++) {
        		sum += arr[i];
        		if(i - len >= 0) sum -= arr[i-len];
        		if(i >= len-1) res += sum;
        	}
        }
        
        return res;
    }
	
}
