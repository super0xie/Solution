
public class CountingElements {
	
	public int countElements(int[] arr) {
        boolean[] exist = new boolean[1001];
        for(int i = 0; i < arr.length; i++) {
        	exist[arr[i]] = true;
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i]+1 < 1001 && exist[arr[i]+1]) res++;
        }
        return res;
        
        
    }
	
}
