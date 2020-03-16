import java.util.HashSet;

public class DistinctEchoSubstrings {
	
	public int distinctEchoSubstrings(String text) {

        HashSet<String> set = new HashSet<String>();
        for(int len = 2; len <= text.length(); len += 2) {
        	
        	for(int i = 0; i + len -1 < text.length(); i++) {
        		int j = i;
        		for(; j < i + len / 2; j++)
        			if(text.charAt(j) != text.charAt(j + len/2)) break;
        		
        		if(j == i + len/2) 
        			set.add(text.substring(i, i + len));
        	}
        	
        }
        
        return set.size();
    }
	
	public static void main(String[] args) {
		DistinctEchoSubstrings test = new DistinctEchoSubstrings();
		System.out.println(test.distinctEchoSubstrings("leetcodeleetcode"));
	}
	
	
	
	
	
	
}
