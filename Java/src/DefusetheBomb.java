
public class DefusetheBomb {
	
	public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k == 0) return res;
        
        if(k > 0) {
        	int sum = 0;
        	for(int i = 0; i < k; i++) sum += code[i];
        	res[n-1] = sum;
        	for(int i = n-2; i >= 0; i--) {
        		sum += code[i+1];
        		int idx = i+k+1;
        		if(idx >= n) idx -= n;
        		sum -= code[idx];
        		res[i] = sum;
        	}
        	
        }else {
        	k = -k;
        	int sum = 0;
        	for(int i = n-1; i >= n-k; i--) sum += code[i];
        	res[0] = sum;
        	
        	for(int i = 1; i < n; i++) {
        		sum += code[i-1];
        		int idx = i-k-1;
        		if(idx < 0) idx += n;
        		sum -= code[idx];
        		res[i] = sum;
        	}
        	
        }
        
        return res;
        
    }
	
	public static void main(String[] args) {
		DefusetheBomb test = new DefusetheBomb();
		int[] code = {2,4,9,3};
		
		System.out.println(test.decrypt(code, -2));
	}
	
}
