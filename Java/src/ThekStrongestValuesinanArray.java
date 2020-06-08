import java.util.Arrays;

public class ThekStrongestValuesinanArray {
	
	public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1)/2];
        int l = 0;
        int r = arr.length-1;
        
        int[] res = new int[k];
        int idx = 0;
        while(idx < k) {
        	int absl = Math.abs(arr[l]-m);
        	int absr = Math.abs(arr[r]-m);
        	if(absl != absr) {
        		if(absl > absr) {
        			res[idx++] = arr[l++];
        		}else {
        			res[idx++] = arr[r--];
        		}
        	}else {
        		if(arr[l] >= arr[r]) {
        			res[idx++] = arr[l++];
        		}else {
        			res[idx++] = arr[r--];
        		}
        	}
        }
        return res;
		
    }
}
