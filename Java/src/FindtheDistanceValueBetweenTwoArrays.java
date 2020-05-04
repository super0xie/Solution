import java.util.Arrays;

public class FindtheDistanceValueBetweenTwoArrays {
	
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        
        int res = 0;
        
        for(int i : arr1) {
        	int ret = Arrays.binarySearch(arr2, i);
        	if(ret >= 0) continue;
        	int ip = -ret-1;
        	
        	if(ip == 0) {
        		if(Math.abs(arr2[0] - i) > d) res++;
        	}else if(ip == arr2.length) {
        		if(Math.abs(arr2[arr2.length-1]-i) > d) res++;
        	}else {
        		if(Math.abs(arr2[ip-1]-i) > d && Math.abs(arr2[ip]-i) > d) res++;
        	}
        	
        }
        
        return res;
        
    }
	
}

