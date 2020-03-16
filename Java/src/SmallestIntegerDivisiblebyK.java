
public class SmallestIntegerDivisiblebyK {
	
	public int smallestRepunitDivByK(int K) {
        int count = 0;
        int rem = 0;
        if(K % 2 == 0 || K % 5 == 0) return -1;
        
        do {
        	int div = rem * 10 + 1;
        	count++;
        	rem = div % K;
        }while(rem != 0);
        
        return count;
        
    }
	
	
	
	public static void main(String[] args) {
		SmallestIntegerDivisiblebyK test = new SmallestIntegerDivisiblebyK();
		System.out.println(test.smallestRepunitDivByK(23));
		
	}
}
