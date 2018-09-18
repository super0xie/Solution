
public class RearrangeStringkDistanceApart {
	public String rearrangeString(String s, int k) {
		if(k == 0) return s;
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
        	count[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
        	int max = 0;
        	int c = 0;
        	int j = 0;
        	for(j = 0; j < 26; j++) {
        		if(count[j] > max && i >= valid[j]) {
        			max = count[j];
        			c = j;
        		}
        	}
        	
        	if(max == 0) return "";
        	
        	sb.append((char)('a' + c));
        	valid[c] = i+k;
        	count[c]--;
        	
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		RearrangeStringkDistanceApart test = new RearrangeStringkDistanceApart();
		System.out.println(test.rearrangeString("aabbcc", 2));
	}

}
