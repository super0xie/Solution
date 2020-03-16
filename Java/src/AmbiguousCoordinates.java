import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
	
	public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i < S.length(); i++) {
        	String l = S.substring(1, i);
        	String r = S.substring(i, S.length()-1);
        	
    		for(int j = 1; j <= l.length(); j++) {
        		for(int k = 1; k <= r.length(); k++) {
        			String ll = l;
        			String rr = r;
        			if(j != l.length()) ll = l.substring(0, j) + "." + l.substring(j);
        			if(k != r.length()) rr = r.substring(0, k) + "." + r.substring(k);
        			
        			if(isLegal(ll) && isLegal(rr))
        				res.add("(" + ll + ", " + rr + ")");
        		}
        	}
        }
        
        return res;
    }
	
	private boolean isLegal(String str) {
		if(str.length() == 1) return true;
		int lz = 0;
		int p = 0;
		int idx = str.indexOf(".");
		while(p < str.length() && str.charAt(p) == '0') {
			p++;
			lz++;
		}
		if(lz >= 2) return false;
		if(lz == 1) {
			if(idx != 1) return false;
		}
		
		int tz = 0;
		p = str.length()-1;
		while(p >= 0 && str.charAt(p) == '0') {
			tz++;
			p--;
		}
		if(idx >= 0 && tz > 0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		AmbiguousCoordinates test = new AmbiguousCoordinates();
		test.ambiguousCoordinates("(123)");
	}
	
}
