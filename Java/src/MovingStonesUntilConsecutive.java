import java.util.Arrays;

public class MovingStonesUntilConsecutive {
	
	
	public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        
        int[] res = new int[2];
        res[1] = arr[1] - arr[0] - 1 + arr[2] - arr[1] -1;
        if(res[1] != 0) {
        	if(arr[1]-arr[0] <= 2 || arr[2]-arr[1] <= 2) res[0] = 1;
        	else res[0] = 2;
        }
        
        return res;
	}
}
