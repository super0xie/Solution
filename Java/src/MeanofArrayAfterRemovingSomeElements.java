import java.util.Arrays;

public class MeanofArrayAfterRemovingSomeElements {
	
	public double trimMean(int[] arr) {
        int n = arr.length * 5 / 100;
        
        int sum = 0;
        Arrays.parallelSort(arr);
        for(int i = n; i < arr.length-n; i++) {
        	sum += arr[i];
        }
        
        return (double)sum / (arr.length-n*2);
        
    }
	
}
