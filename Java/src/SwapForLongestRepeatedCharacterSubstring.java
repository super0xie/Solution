
public class SwapForLongestRepeatedCharacterSubstring {
	
	public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int[] cur = new int[26];
        for(int i = 0; i < text.length(); i++) 
        	count[text.charAt(i)-'a']++;
        
        
        int l = 0;
        int r = -1;
        int res = Integer.MIN_VALUE;
        
        while(r < text.length()) {
        	if(valid(cur, count)) {
        		res = Math.max(res, r-l+1);
        		r++;
        		if(r < text.length())
        			cur[text.charAt(r)-'a']++;
        	}else {
        		cur[text.charAt(l)-'a']--;
        		l++;
        	}
        }
        
        return res;
    }
	
	private boolean valid(int[] cur, int[] count) {
		int num = 0;
		int pre = -1;
		for(int i = 0; i < 26; i++) {
			if(cur[i] == 0) continue;
			num++;
			
			if(num > 2) return false;
			if(num == 1) {
				pre = i;
				continue;
			}
			
			if((cur[pre] == 1 && count[i] > cur[i]) || (cur[i] == 1 && count[pre] > cur[pre])) {
				continue;
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		SwapForLongestRepeatedCharacterSubstring test = new SwapForLongestRepeatedCharacterSubstring();
		System.out.println(test.maxRepOpt1("abcdef"));
	}
	
}
