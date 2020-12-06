
public class NumberofSubstringsWithOnly1s {
	
	public int numSub(String s) {
        long res = 0;
        int mod = 1_000_000_000 + 7;
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '0') continue;
        	
        	int j = i+1;
        	while(j < s.length() && s.charAt(j) == '1') j++;
        	
        	long len = j-i;
        	
        	res += (1 + len) * len / 2;
        	res = res % mod;
        	
        	i = j-1;
        }
        
        return (int)res;
    }
}
