
public class ArrangingCoins {
	
	public int arrangeCoins(int n) {
        int init = (int)Math.sqrt((double)2*n);
        
        while(((double)init * (init+1))/2 > n) init--;
        return init;
        
    }
	
	public static void main(String [] args) {
		int n = 1804289383;
		ArrangingCoins test = new ArrangingCoins();
		System.out.println(test.arrangeCoins(n));
		
//		System.out.println((int)Math.sqrt((double)2*n));
//		int init = 60071;
//		System.out.println(((double)init * (init+1)));
//		System.out.println((double)(init * (init+1))/2);
	}

}
