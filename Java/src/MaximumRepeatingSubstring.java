
public class MaximumRepeatingSubstring {
	
	public int maxRepeating(String sequence, String word) {
        int res = 0;
        
        for(int i = 0; i < sequence.length(); i++) {
        	int idx = 0;
        	int count = 0;
        	for(int j = i; j < sequence.length(); j++) {
        		if(sequence.charAt(j) != word.charAt(idx)) break;
        		idx++;
        		if(idx == word.length()) {
        			idx = 0;
        			count++;
        		}
        	}
        	
        	res = Math.max(res, count);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumRepeatingSubstring test = new MaximumRepeatingSubstring();
		test.maxRepeating("ababc", "ba");
	}
	
}
