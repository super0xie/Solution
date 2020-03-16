
public class FindNUniqueIntegersSumuptoZero {
	public int[] sumZero(int n) {
        int[] res = new int[n];
       
        for(int i = 0; i < n-1; i++) {
        	res[i] = i;
        }
        
        res[n-1] = (n-2)*(n-1)/2 * -1;
        
        return res;
    }
	
	public static void main(String[] args){
		FindNUniqueIntegersSumuptoZero test = new FindNUniqueIntegersSumuptoZero();
		int[] res = test.sumZero(1000);
		for(int i : res) System.out.println(i);
	}
}
