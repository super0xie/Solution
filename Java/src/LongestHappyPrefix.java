import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestHappyPrefix {
	
	public String longestPrefixTLE(String s) {
        for(int i = s.length()-2; i >= 0; i--) {
        	int j = i;
        	int k = s.length()-1;
        	for(; j >= 0; j--) {
        		if(s.charAt(j) != s.charAt(k)) break;
        		k--;
        	}
        	if(j < 0) return s.substring(0, i+1);
        }
        
        return "";
    }
	
	public String longestPrefixWrong(String s) {
        long shash = 0;
        long p = 31;
        long mod = 1000000009;
        long ppow = 1;
        HashSet<Long> set = new HashSet<>();
        for(int i = s.length()-1; i >= 0; i--) {
        	shash = ((s.charAt(i) - 'a' + 1) + shash * p) % mod;
        	set.add(shash);
        }
        
        long phash = 0;
        int max = 0;
        for(int i = 0; i < s.length()-1; i++) {
        	phash = (phash + (s.charAt(i)-'a'+1) * ppow) % mod;
        	ppow = (ppow * p) % mod;
        	
        	if(set.contains(phash)) {
        		max = i+1;
        	}
        	
        }
        
        return s.substring(0, max);
    }
	
	public String longestPrefix(String s) {
        long shash = 0;
        long p = 31;
        long mod = 1000000009;
        long ppow = 1;
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for(int i = s.length()-1; i >= 0; i--) {
        	shash = ((s.charAt(i) - 'a' + 1) + shash * p) % mod;
        	if(!map.containsKey(shash)) map.put(shash, new ArrayList<>());
        	map.get(shash).add(i);
        }
        
        long phash = 0;
        int max = 0;
        for(int i = 0; i < s.length()-1; i++) {
        	phash = (phash + (s.charAt(i)-'a'+1) * ppow) % mod;
        	ppow = (ppow * p) % mod;
        	int j = s.length()-1-i;
        	if(map.containsKey(phash)) {
        		for(int k : map.get(phash)) {
        			if(k == j) {
        				int m = i;
        				int n = s.length()-1;
        				while(m >= 0) {
        					if(s.charAt(m--) != s.charAt(n--)) break;
        				}
        				
        				if(m < 0) max = i+1;
        			}
        		}
        	}
        	
        }
        
        return s.substring(0, max);
    }
	
	public static void main(String[] args) {
		LongestHappyPrefix test = new LongestHappyPrefix();
		String str = "a";
		System.out.print(test.longestPrefix(str));
	}
}
