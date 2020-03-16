
public class SingleRowKeyboard {
	
	public int calculateTime(String keyboard, String word) {
		int[] loc = new int[26];
		for(int i = 0; i < keyboard.length(); i++) {
			loc[keyboard.charAt(i)-'a'] = i;
		}
		int cur = 0;
		
		int res = 0;
		for(int i = 0; i < word.length(); i++) {
			int tar = loc[word.charAt(i)-'a'];
			res += Math.abs(tar - cur);
			cur = tar;
		}
		
		return res;
    }
	
}
