
public class CanConvertStringinKMoves {
	
	public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length()) return false;
        int[] count = new int[27];
        int n = k / 26;
        for(int i = 1; i < 27; i++) count[i] = n;
        for(int i = 1; i <= k % 26; i++) count[i]++;
        
        for(int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	int diff = (int)(c2-c1);
        	if(diff == 0) continue;
        	if(diff < 0) diff += 26;
        	
        	if(count[diff] == 0) return false;
        	count[diff]--;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		CanConvertStringinKMoves test = new CanConvertStringinKMoves();
		test.canConvertString("input", "ouput", 9);
		System.out.println('a'-'b');
	}
	
}
