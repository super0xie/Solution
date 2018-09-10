import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
	
	public boolean wordBreakable(String s, List<String> wordDict) {
        boolean [] dp = new boolean [s.length()+1];
        dp[0] = true;
        
        for(int i = 0; i < s.length(); i++) {
        	for(String str : wordDict) {
        		if(i + 1>= str.length()) {
        			if(dp[i-str.length()+1] && s.substring(i + 1 - str.length(), i+1).equals(str)){
        				dp[i+1] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[s.length()];
        
    }
	
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		boolean breakable = wordBreakable(s, wordDict);
		if(!breakable) return new ArrayList<String>();
		
		List<List<String>> mem = new ArrayList<List<String>>();
		for(int i = 0; i < s.length(); i++) {
			mem.add(new ArrayList<String>());
		}
		
		List<String> res = dfs(s, 0, wordDict, mem);
		
		return res;
    }
	
	private List<String> dfs(String s, int index, List<String> wordDict, List<List<String>> mem) {
		if(mem.get(index).size() > 0) return mem.get(index);
		List<String> ret = new ArrayList<String>();
		for(String str : wordDict) {
			if(s.startsWith(str, index)) {
				if(s.length() - index == str.length()) ret.add(str);
				else {
					List<String> suffix = dfs(s, index+str.length(), wordDict, mem);
					for(String suf : suffix) {
						ret.add(str + " " + suf);
					}
				}
				
			}
			
		}
		mem.set(index, ret);
		return ret;
		
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		WordBreakII test = new WordBreakII();
		test.wordBreak(s, wordDict);
		
	}

}
