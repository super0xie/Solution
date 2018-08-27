
public class Powxn {
	
    public double myPow(double x, int n) {

    	if(n == 0) return 1;
    	if(x == 1) return 1;
    	if(x == -1) {
    		if(n%2 == 0) return 1;
    		else return -1;
    	}
    	
    	boolean flag = false;
    	if(n < 0) {
    		x = 1 / x;
    		if(n == -2147483648) {
    			n = 2147483647;
    			flag = true;
    		}
    		else{
    			n = -n;
    		}
    	}
    	
    	
    	
    	double prefix = x;
    	if(n > 1048576) {
    		for(int i = 0; i < 20; i++) {
    			prefix = prefix * prefix;
    		}
    	}

    	System.out.println(prefix);
    	if(prefix == 0.0) return 0.0;
    	
    	
    	double result = powHelper(x, n);
    	if(flag) result *= x;
        return result;
  
    }
    
    
    private double powHelper(double x, int n) {
    	if(n == 1) return x;
    	
    	if(n % 2 == 0) return powHelper(x, n/2) * powHelper(x, n/2);
    	else return powHelper(x, n/2) * powHelper(x, n/2) * x;
    	
    }
    
    public static void main(String[] args) {
    	double x = 0.999999999999999;
    	Powxn test = new Powxn();
    	
    	System.out.println(test.myPow(x, 2147483647));
    	
//    	int a = -2147483648;
//    	System.out.println(-a);
    }
    
}
