import java.util.Arrays;

public class HowManyApplesCanYouPutintotheBasket {
	
	public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        int w = 0;
        for(int i = 0; i < arr.length; i++) {
        	w += arr[i];
        	if(w > 5000) return res;
        	res++;
        }
        return res;
    }
	
}
