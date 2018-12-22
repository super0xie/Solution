
public class VerifyinganAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		int[] idx = new int[26];
		for(int i = 0; i < order.length(); i++) {
			idx[order.charAt(i)-'a'] = i;
		}
		
		for(int i = 0; i < words.length; i++) {
			if(!helper(words[i], words[i+1], idx)) return false;
		}
		return true;
    }
	
	
	private boolean helper(String str1, String str2, int[] idx) {
		for(int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
			int idx1 = idx[str1.charAt(i)-'a'];
			int idx2 = idx[str2.charAt(i)-'a'];
			if(idx1 < idx2) return true;
			else if(idx1 > idx2) return false;
		}
		
		if(str1.length() > str2.length()) return false;
		return true;
	}
	
}
