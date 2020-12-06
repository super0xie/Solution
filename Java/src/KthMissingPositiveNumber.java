
public class KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int count = 0;
        int n = 1;
        while(count < k) {
        	if(i < arr.length && arr[i] == n) i++;
        	else count++;
        	n++;
        }
        
        return n-1;
    }
}
