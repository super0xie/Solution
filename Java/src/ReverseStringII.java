
public class ReverseStringII {
	
	public String reverseStr(String s, int k) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
        	int j = i + k - 1;
        	j = Math.min(j, s.length()-1);
        	while(j >= i) {
        		sb.append(s.charAt(j--));
        	}
        	
        	if(i+k <= s.length()-1)
        		sb.append(s.substring(i+k, Math.min(s.length(), i+2*k)));
        	
        	i = i + 2 * k;
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		ReverseStringII test = new ReverseStringII();
		System.out.println(test.reverseStr("abcdefg", 2));
	}
	
}
