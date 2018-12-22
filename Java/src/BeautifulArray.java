
public class BeautifulArray {
	
	public int[] beautifulArray(int N) {
        if(N == 1) return new int [] {1};
        int[] l = beautifulArray(N/2);
        int[] r = beautifulArray(N - N/2);
        
        int [] res = new int [N];
        for(int i = 0; i < l.length; i++) {
        	res[i] = l[i] * 2;
        }
        
        for(int i = l.length; i - l.length < r.length; i++) {
        	res[i] = r[i-l.length] * 2 - 1;
        }
        
        return res;
        
    }
	
	public static void main(String[] args) {
		BeautifulArray test = new BeautifulArray();
		test.beautifulArray(3);
	}
	
}
