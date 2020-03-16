
public class RemoveAllAdjacentDuplicatesinStringII {
	
	public String removeDuplicates(String s, int k) {
		boolean cont = true;
		
        while(cont) {
        	cont = false;
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < s.length(); i++) {
        		int j = i+1;
        		while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;
        		int len = j - i;
        		if(len >= k) cont = true;
        		
        		int mod = len % k;
        		i = j - mod;
        		sb.append(s.substring(i, j));
        		i = j-1;
        	}
        	
        	s = sb.toString();
        }
        
        return s;
    }
	
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesinStringII test = new RemoveAllAdjacentDuplicatesinStringII();
		System.out.println(test.removeDuplicates("pbbcggttciiippooaais", 2));
	}
}
