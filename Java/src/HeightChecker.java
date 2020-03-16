import java.util.Arrays;

public class HeightChecker {
	
	public int heightChecker(int[] heights) {
		int[] sort = new int [heights.length];
		for(int i = 0; i < heights.length; i++) {
			sort[i] = heights[i];
		}
		
		Arrays.sort(sort);
		
		int res = 0;
		
		for(int i = 0; i < heights.length; i++) {
			if(sort[i] != heights[i]) res++;
		}
		
		return res;
        
    }

}
