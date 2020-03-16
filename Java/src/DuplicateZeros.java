
public class DuplicateZeros {
	public void duplicateZeros(int[] arr) {
        int[] res = new int[arr.length];
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 0) {
        		res[idx++] = 0;
        		if(idx == arr.length) break;
        	}
        	
        	res[idx++] = arr[i];
        	if(idx == arr.length) break;
        }
        
        for(int i = 0; i < arr.length; i++) arr[i] = res[i];
        
    }
}
