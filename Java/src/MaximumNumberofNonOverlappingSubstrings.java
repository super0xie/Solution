import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNumberofNonOverlappingSubstrings {
	public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        int l = 0;
        int[] last = new int[26];
        int[] first = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(first, -1);
        for(int i = 0; i < s.length(); i++) 
        	last[s.charAt(i)-'a'] = i;
        
        for(int i = s.length()-1; i >= 0; i--) 
        	first[s.charAt(i)-'a'] = i;
        
        while(l < s.length()) {
        	int cur = l;
        	int end = last[s.charAt(l)-'a'];
        	int start = l;
        	boolean valid = true;
        	while(cur < end) {
        		if(first[s.charAt(cur)-'a'] < l) {
        			valid = false;
        			break;
        		}
        		
        		if(last[s.charAt(cur)-'a'] >= 0 && last[s.charAt(cur)-'a'] < end && first[s.charAt(cur)-'a'] == cur) {
        			end = last[s.charAt(cur)-'a'];
        			start = cur;
        		}else {
        			end = Math.max(end, last[s.charAt(cur)-'a']);
                    start = Math.min(start, first[s.charAt(cur)-'a']);
        		}
        		cur++;
        	}
        	
        	if(valid && first[s.charAt(start)-'a'] == start) {
            	for(int i = start; i <= end; i++) {
            		start =  Math.min(start, first[s.charAt(i)-'a']);
            		end = Math.max(end, last[s.charAt(i)-'a']);
            	}
        		res.add(s.substring(start, end+1));
        		l = end+1;
        	}else {
        		l++;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumNumberofNonOverlappingSubstrings test = new MaximumNumberofNonOverlappingSubstrings();
		List<String> res = test.maxNumOfSubstrings("dacdbdedea");
		for(String s : res) System.out.println(s);
	}
	
}
