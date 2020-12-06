
public class FindtheWinnerofanArrayGame {
	
	public int getWinner(int[] arr, int k) {
		if(k == 1) return Math.max(arr[0], arr[1]);
        int cur = arr[0];
        int count = 0;
        
        for(int i = 1; i < arr.length; i++) {
        	if(arr[i] > cur) {
        		count = 1;
        		cur = arr[i];
        	}else {
        		count++;
        	}
        	if(count == k) return cur;
        }
        
        return cur;
    }
	
	public static void main(String[] args) {
		FindtheWinnerofanArrayGame test = new FindtheWinnerofanArrayGame();
		int[] arr = {1,11,22,33,44,55,66,77,88,99};
		System.out.print(test.getWinner(arr, 1000000000));
	}
	
}
