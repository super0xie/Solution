
public class SlowestKey {
	
	public char slowestKey(int[] releaseTimes, String keysPressed) {
        int m = releaseTimes[0];
        char res = keysPressed.charAt(0);
        
        for(int i = 1; i < releaseTimes.length; i++) {
        	int d = releaseTimes[i]-releaseTimes[i-1];
        	if(d > m) {
        		m = d;
        		res = keysPressed.charAt(i);
        	}else if(d == m) {
        		if(keysPressed.charAt(i) > res) res = keysPressed.charAt(i);
        	}
        }
        return res;
    }
	
}
