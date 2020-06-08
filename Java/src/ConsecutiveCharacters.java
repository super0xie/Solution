
public class ConsecutiveCharacters {
	public int maxPower(String s) {
        int res = 1;
        int count = 1;
        
        for(int i = 1; i < s.length(); i++) {
        	if(s.charAt(i) != s.charAt(i-1)) {
        		count = 1;
        	}else {
        		count++;
        	}
        	
        	res = Math.max(res, count);
        }
        return res;
    }
}
