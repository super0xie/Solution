
public class NumberofWaystoSplitaString {
	
	public int numWays(String s) {
		int mod = 1000000000+7;
        int count = 0;
        for(int i = 0; i < s.length(); i++) 
        	if(s.charAt(i) == '1') count++;
        if(count == 0) return (int)((long)(s.length()-1) * (s.length()-2) / 2 % mod);
        if(count % 3 != 0) return 0;
        int n = count / 3;
        count = 0;
        int i = -1;
        while(count < n) {
        	i++;
        	if(s.charAt(i) == '1') count++;
        }
        
        int ii = i+1;
        while(s.charAt(ii) != '1') ii++;
        
        
        count = 0;
        int j = s.length();
        while(count < n) {
        	j--;
        	if(s.charAt(j) == '1') count++;
        }
        
        int jj = j-1;
        while(s.charAt(jj) != '1') jj--;
        
        return (int)((long)(ii-i) * (j - jj) % mod);
        
    }
	
	public static void main(String[] args) {
		NumberofWaystoSplitaString test = new NumberofWaystoSplitaString();
		System.out.println(test.numWays("100100010100110"));
	}
	
}
