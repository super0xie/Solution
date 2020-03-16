import java.util.ArrayList;
import java.util.List;

public class ArrayTransformation {
	
	public List<Integer> transformArray(int[] arr) {
        List<Integer> res = new ArrayList<>();
        
        boolean cont = true;
        while(cont) {
        	cont = false;
        	int[] aux = new int[arr.length];
        	
        	for(int i = 1; i < arr.length-1; i++) {
        		if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
        			cont = true;
        			aux[i] = arr[i]-1;
        		}
        		else if(arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
        			cont = true;
        			aux[i] = arr[i]+1;
        		}
        		else aux[i] = arr[i];
        	}
        	
        	aux[0] = arr[0];
        	aux[arr.length-1] = arr[arr.length-1];
        	
        	arr = aux;
        }
        
        for(int i = 0; i < arr.length; i++) res.add(arr[i]);
        return res;
    }
	
}
