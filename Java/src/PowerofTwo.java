
public class PowerofTwo {
	
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0) return false;
        if(n == 1 || n == 2) return true;
        
        if(n % 2 == 0) return isPowerOfTwo(n/2);
        else return false;
    }
    
}
