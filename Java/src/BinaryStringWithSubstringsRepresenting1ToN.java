
public class BinaryStringWithSubstringsRepresenting1ToN {
	
	public boolean queryString(String S, int N) {
		if(N >= 256) return false;
		
		for(int i = 0; i <= N; i++) {
			String str = Integer.toBinaryString(i);
			if(!S.contains(str)) return false;
		}
		
        return true;
    }
	
}
