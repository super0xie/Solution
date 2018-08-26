
public class GuessNumberHigherorLower extends GuessGame {

	public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	int result  = guess(mid);
        	if(result == 0) return mid;
        	if(result < 0) end = mid - 1;
        	else start = mid + 1;
        }
        
        return -1;
		
    }
	
}
