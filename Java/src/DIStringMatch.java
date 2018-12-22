
public class DIStringMatch {
	
	public int[] diStringMatch(String S) {
		int l = 0;
		int r = S.length();
		
		int idx = 0;
		int[] res = new int[S.length()+1];
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == 'I') res[i] = l++;
			else res[i] = r--;
		}
		
		res[S.length()] = l;
		return res;
	
    }
	
	public static void main(String[] args) {
		DIStringMatch test = new DIStringMatch();
		int[] res = test.diStringMatch("III");
		System.out.println("test");
	}
}
