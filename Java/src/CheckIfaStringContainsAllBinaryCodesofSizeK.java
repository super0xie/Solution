import java.util.HashSet;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
	
	public boolean hasAllCodes(String s, int k) {
        int cur = 0;
        int mod = 1;
        for(int i = 0; i < k; i++) mod *= 2;
        
        boolean[] visited = new boolean[mod];
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
        	cur = cur << 1;
        	if(s.charAt(i) == '1') cur++;
        	if(i >= k) {
        		cur = cur % mod;
        	}
        	
        	if(i >= k-1 && !visited[cur]) {
        		res++;
        		visited[cur] = true;
        	}
        }
        
        if(res == mod) return true;
        return false;
    }
	
	public static void main(String[] args) {
		CheckIfaStringContainsAllBinaryCodesofSizeK test = new CheckIfaStringContainsAllBinaryCodesofSizeK();
		System.out.println(test.hasAllCodes("0110", 2));
	}
	
}
