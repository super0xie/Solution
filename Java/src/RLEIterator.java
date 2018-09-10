
public class RLEIterator {
	
	private int index = 0;
	private int[] A;
	
	public RLEIterator(int[] A) {
        this.A = A;
    }
    
    public int next(int n) {
    	if(index >= A.length) return -1;
    	if(A[index] == 0) {
    		index += 2;
    		return next(n);
    	}
    	
    	while(index < A.length && n > 0) {
    		int a = A[index];
    		int b = n;
    		A[index] -= Math.min(a, b);
    		n -= Math.min(a, b);
    		if(n > 0) index += 2;
    		else if(n == 0) {
    			return A[index+1];
    		}
    	}
    	return -1;
        
    }
    
    public static void main(String[] args) {
    	int[] A = {3,8,0,9,2,5};
    	RLEIterator test = new RLEIterator(A);
    	System.out.println(test.next(2));
    	
    	
    }

}
