
public class SmallestStringWithAGivenNumericValue {
	
	public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        
        for(int i = 0; i < n; i++) {
        	int remain = (n-i-1) * 26;
        	if(k <= remain+1) {
        		res[i] = 'a';
        		k--;
        	} else {
        		res[i] = (char)('a' + k-remain-1);
        		k -= k-remain;
        	}
        }
        
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		SmallestStringWithAGivenNumericValue test = new SmallestStringWithAGivenNumericValue();
		System.out.print(test.getSmallestString(5, 73));
	}
}
