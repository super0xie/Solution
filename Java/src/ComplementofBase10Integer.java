
public class ComplementofBase10Integer {
	
	public int bitwiseComplement(int N) {
		if(N == 0) return 1;
        int res = 0;
        int m = 0x40000000;
        boolean start = false;
        
        while(m > 0) {
        	int a = N & m;
        	m = m >>> 1;
        	
        	if(a > 0) {
        		start = true;
        	}
        	
        	res = res << 1;
        	
        	if(a == 0 && start) {
        		res += 1;
        	}
        	
        }
        return res;
    }
	
	public static void main(String[] args) {
		ComplementofBase10Integer test = new ComplementofBase10Integer();
		System.out.println(test.bitwiseComplement(0));
		
	}
	
}
