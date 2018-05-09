import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
    
    private boolean wordBreakHelper(String s, List<String> wordDict, int startIndex) {
    	
    	boolean result = false;
    	for(String str : wordDict) {
    		if(s.regionMatches(startIndex, str, 0, str.length())) {
    			if(startIndex + str.length() == s.length()) return true;
    			result = result || wordBreakHelper(s, wordDict, startIndex+str.length());
    		}
    	}
    	
    	return result;
    }
    
    public boolean wordBreak2(String s, List<String> wordDict) {
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
    
    public static void main(String[] args) {
    	WordBreak wb = new WordBreak();
    	System.out.println(wb.wordBreak2("leetcode", Arrays.asList("leet", "code")));
    	System.out.println(wb.wordBreak2("applepenapple", Arrays.asList("apple", "pen")));
    	System.out.println(wb.wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
