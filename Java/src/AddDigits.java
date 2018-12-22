
public class AddDigits {
	
	public int addDigits(int n) {
        while(n >= 10) {
        	int aux = n;
        	int sum = 0;
        	while(aux > 0) {
        		sum += aux % 10;
        		aux = aux / 10;
        	}
        	n = sum;
        }
        return n;
    }
}
