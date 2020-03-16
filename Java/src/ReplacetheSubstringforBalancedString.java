
public class ReplacetheSubstringforBalancedString {
	
	public int balancedString(String s) {
        int[] counts = new int[4];
        int tar = s.length()/4;
        for(int i = 0; i < s.length(); i++) {
        	counts[getIdx(s.charAt(i))]++;
        }
        
        if(counts[0] == tar && counts[1] == tar && counts[2] == tar && counts[3] == tar) return 0;
        
        int[] cur = new int[4];
        int l = 0;
        int r = -1;
        int res = Integer.MAX_VALUE;
        
        while(r < s.length()) {
        	if(helper(cur, counts, tar)) {
        		res = Math.min(res, r-l+1);
        		//legal already, try to shorten
        		if(l < r) {
        			cur[getIdx(s.charAt(l))]--;
        			l++;
        		}else {
        			r++;
        			if(r < s.length())
        				cur[getIdx(s.charAt(r))]++;
        		}
        	} else {
        		r++;
    			if(r < s.length())
    				cur[getIdx(s.charAt(r))]++;
        	}
        	
        }
        
        return res;
    }
	
	private int getIdx(char c) {
		if(c == 'Q') return 0;
		else if(c == 'W') return 1;
		else if(c == 'E') return 2;
		else return 3;
	}
	
	private boolean helper(int[] cur, int[] counts, int tar) {
		int[] out = new int[4];
		for(int i = 0; i < 4; i++) {
			out[i] = counts[i] - cur[i];
			if(out[i] > tar) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ReplacetheSubstringforBalancedString test = new ReplacetheSubstringforBalancedString();
		System.out.println(test.balancedString("QQQQ"));
	}
	
}
