
public class ThousandSeparator {
	
	public String thousandSeparator(int n) {
        int count = 0;
        if(n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        	int d = n % 10;
        	n = n / 10;
        	sb.append(d);
        	count++;
        	if(count == 3 && n != 0) {
        		sb.append('.');
        		count = 0;
        	}
        }
        
        return sb.reverse().toString();
    }
	
}
