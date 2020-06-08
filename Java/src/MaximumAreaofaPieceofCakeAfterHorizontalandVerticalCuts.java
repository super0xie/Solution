import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
	
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		
		
        int maxh = horizontalCuts[0];
        for(int i = 1; i < horizontalCuts.length; i++) {
        	maxh = Math.max(horizontalCuts[i]-horizontalCuts[i-1], maxh);
        }
        maxh = Math.max(maxh, h-horizontalCuts[horizontalCuts.length-1]);
        
        int maxw = verticalCuts[0];
        for(int i = 1; i < verticalCuts.length; i++) {
        	maxw = Math.max(maxw, verticalCuts[i]-verticalCuts[i-1]);
        }
        maxw = Math.max(maxw, w-verticalCuts[verticalCuts.length-1]);
        
        return (int)(((long)maxh*maxw)%1000000007);
    }
	
}
