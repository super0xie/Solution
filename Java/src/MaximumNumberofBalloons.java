
public class MaximumNumberofBalloons {
	
	public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for(int i = 0; i < text.length(); i++) {
        	count[text.charAt(i)-'a']++;
        }
        
        int res = Integer.MAX_VALUE;
        
        res = Math.min(count['b'-'a'] / 1, res);
        res = Math.min(count['a'-'a'] / 1, res);
        res = Math.min(count['l'-'a'] / 2, res);
        res = Math.min(count['o'-'a'] / 2, res);
        res = Math.min(count['n'-'a'] / 1, res);
        return res;
    }
	
	public static void main(String[] args) {
		MaximumNumberofBalloons test = new MaximumNumberofBalloons();
		System.out.println(test.maxNumberOfBalloons("leetcode"));
	}
	
}
