
public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length()-1; i++) {
        	if(s.charAt(i) != s.charAt(i+1)) {
        		int m = i;
        		int n = i+1;
        		while(m > 0 && s.charAt(m) == s.charAt(i) && n < s.length() && s.charAt(n) == s.charAt(i+1)) {
        			res++;
        			m--;
        			n++;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		CountBinarySubstrings test = new CountBinarySubstrings();
		test.countBinarySubstrings("00110");
	}
}
