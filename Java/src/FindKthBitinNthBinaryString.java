
public class FindKthBitinNthBinaryString {
	
	public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        int len = helper(n) - 1;
        
        int m = (len+1)/2;
        
        if(k == m) return '1';
        if(k < m) {
        	return findKthBit(n-1, k);
        }else {
        	int pl = (len-1)/2;
        	k = k - 1 - pl;
        	k = pl+1-k;
        	char c = findKthBit(n-1, k);
        	if(c == '0') return '1';
        	return '0';
        }
    }
	
	private int helper(int n) {
		int res = 1;
		for(int i = 0; i < n; i++) 
			res = res * 2;
		return res;
	}
	
	public static void main(String[] args) {
		FindKthBitinNthBinaryString test = new FindKthBitinNthBinaryString();
		System.out.println(test.findKthBit(2, 3));
	}
	
}
