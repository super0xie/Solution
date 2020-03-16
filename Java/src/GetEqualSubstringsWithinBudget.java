
public class GetEqualSubstringsWithinBudget {
	
	public int equalSubstring(String s, String t, int maxCost) {
		int[] cost = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			cost[i] = Math.abs((int)s.charAt(i)-(int)t.charAt(i));
		}
		
		int i = -1;
		int j = 0;
		int c = 0;
		int res = -1;
		
		while(i < s.length() && j < s.length()) {
			if(c <= maxCost) res = Math.max(res, i-j+1);
			if(c <= maxCost) {
				i++;
				if(i < s.length()) c += cost[i];
			}else {
				c -= cost[j];
				j++;
			}
		}
		
		return res;
        
    }
	
	public static void main(String[] args) {
		GetEqualSubstringsWithinBudget test = new GetEqualSubstringsWithinBudget();
		System.out.println(test.equalSubstring("abcd", "acde", 0));
	}
	
}
