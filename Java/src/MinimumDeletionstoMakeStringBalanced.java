
public class MinimumDeletionstoMakeStringBalanced {
	
	public int minimumDeletions(String s) {
        int a = 0;
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == 'a') a++;
        int res = a;
        int counta = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == 'a') counta++;
        	int bl = i+1-counta;
        	int ar = a - counta;
        	res = Math.min(res, bl + ar);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MinimumDeletionstoMakeStringBalanced test = new MinimumDeletionstoMakeStringBalanced();
		System.out.println(test.minimumDeletions("bbaaaaabb"));
	}
	
}
