import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	set.add(n);
    	
    	while(true) {
    		int sum = 0;
        	while(n > 0) {
        		sum += (n%10)*(n%10);
        		n = n / 10;
        	}
        	if(sum == 1) return true;
        	if(set.contains(sum)) return false;
        	
        	set.add(sum);
        	
        	n = sum;
    	}
    }
    
    public static void main(String[] args) {
    	HappyNumber hn = new HappyNumber();
    	System.out.println(hn.isHappy(19));
    }
}
