
public class LongestSubstringwithAtMostKDistinctCharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int l = 0;
		int r = 0;
		
		int [] count = new int [256];
		int size = 0;
		int res = 0;
		for(; r < s.length(); r++) {
			char c = s.charAt(r);
			count[c]++;
			if(count[c] == 1) size++;
			
			while(size > k) {
				count[s.charAt(l)]--;
				if(count[s.charAt(l)] == 0) size--;
				l++;
			}
			
			res = Math.max(res, r-l+1);
			
		}
		
		return res;
        
    }
	
}
