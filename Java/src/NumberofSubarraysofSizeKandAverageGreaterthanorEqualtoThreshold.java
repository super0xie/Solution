
public class NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {
	
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int sum = 0;
		int res = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(i - k >= 0) sum -= arr[i-k];
			if(i >= k-1) {
				int avg = sum / k;
				
				if(avg >= threshold) res++;
			}
			
		}
		
		return res;
	}
}
