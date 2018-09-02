import java.util.HashSet;

public class LongestWordinDictionary {
	
	HashSet<String> set;
	String res = "";
	public String longestWord(String[] words) {
        set = new HashSet<String>();
        for(String str: words) {
        	set.add(str);
        }
        
        dfs("");
        
        return res;
    }
	
	private void dfs(String str) {
		
		char[] chars = new char [str.length() + 1];
		for(int i = 0; i < str.length(); i++) {
			chars[i] = str.charAt(i);
		}
		for(char c = 'a'; c <= 'z'; c++) {
			chars[str.length()] = c;
			String next = String.valueOf(chars);
			if(set.contains(next)) {
				if(next.length() > res.length()) res = next;
				dfs(next);
			}
		}
	}
}
