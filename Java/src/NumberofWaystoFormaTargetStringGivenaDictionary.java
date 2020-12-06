
public class NumberofWaystoFormaTargetStringGivenaDictionary {
	
//	public int numWays(String[] words, String target) {
//		int m = target.length();
//		int n = words[0].length();
//		int mod = 1_000_000_000 + 7;
//        long[][] dp = new long[m][n];
//        
//        for(int i = 0; i < m; i++) {
//        	int remain = m-i-1;
//        	
//        	for(int j = i; j < n-remain; j++) {
//        		long count = 0;
//        		for(int k = 0; k < words.length; k++) {
//        			if(target.charAt(i) == words[k].charAt(j)) count++;
//        		}
//        		
//        		if(i == 0) dp[i][j] = count;
//        		else {
//        			long sum = 0;
//        			for(int k = 0; k < j; k++) sum += dp[i-1][k];
//        			dp[i][j] = count * sum;
//        			dp[i][j] %= mod;
//        		}
//        	}
//        }
//        
//        long res = 0;
//        for(int i = 0; i < n; i++) {
//        	res += dp[m-1][i];
//        	res = res % mod;
//        }
//        return (int)res;
//    }
	
	public int numWays(String[] words, String target) {
		int m = target.length();
		int n = words[0].length();
		int mod = 1_000_000_000 + 7;
        long[][] dp = new long[m][n];
        long[] pre = new long[n];
        long[] cur = new long[n];
        
        for(int i = 0; i < m; i++) {
        	int remain = m-i-1;
        	
        	for(int j = i; j < n-remain; j++) {
        		long count = 0;
        		for(int k = 0; k < words.length; k++) {
        			if(target.charAt(i) == words[k].charAt(j)) count++;
        		}
        		
        		if(i == 0) dp[i][j] = count;
        		else {
        			long sum = pre[j-1];
        			dp[i][j] = count * sum;
        			dp[i][j] %= mod;
        		}
        		
        		cur[j] = dp[i][j];
        		if(j > 0) cur[j] += cur[j-1];
    			cur[j] %= mod;
        	}
        	
        	pre = cur;
        	cur = new long[n];
        }
        
        return (int)pre[n-1];
    }
	
	public static void main(String[] args) {
		NumberofWaystoFormaTargetStringGivenaDictionary test = new NumberofWaystoFormaTargetStringGivenaDictionary();
		String[] words = {"cabbaacaaaccaabbbbaccacbabbbcb","bbcabcbcccbcacbbbaacacaaabbbac","cbabcaacbcaaabbcbaabaababbacbc","aacabbbcaaccaabbaccacabccaacca","bbabbaabcaabccbbabccaaccbabcab","bcaccbbaaccaabcbabbacaccbbcbbb","cbbcbcaaaacacabbbabacbaabbabaa","cbbbbbbcccbabbacacacacccbbccca","bcbccbccacccacaababcbcbbacbbbc","ccacaabaaabbbacacbacbaaacbcaca","bacaaaabaabccbcbbaacacccabbbcb","bcbcbcabbccabacbcbcaccacbcaaab","babbbcccbbbbbaabbbacbbaabaabcc","baaaacaaacbbaacccababbaacccbcb","babbaaabaaccaabacbbbacbcbababa","cbacacbacaaacbaaaabacbbccccaca","bcbcaccaabacaacaaaccaabbcacaaa","cccbabccaabbcbccbbabaaacbacaaa","bbbcabacbbcabcbcaaccbcacacccca","ccccbbaababacbabcaacabaccbabaa","caaabccbcaaccabbcbcaacccbcacba","cccbcaacbabaacbaaabbbbcbbbbcbb","cababbcacbabcbaababcbcabbaabba","aaaacacaaccbacacbbbbccaabcccca","cbcaaaaabacbacaccbcbcbccaabaac","bcbbccbabaccabcccacbbaacbbcbba","cccbabbbcbbabccbbabbbbcaaccaab","acccacccaabbcaccbcaaccbababacc","bcacabaacccbbcbbacabbbbbcaaaab","cacccaacbcbccbabccabbcbabbcacc","aacabbabcaacbaaacaabcabcaccaab","cccacabacbabccbccaaaaabbcacbcc","cabaacacacaaabaacaabababccbaaa","caabaccaacccbaabcacbcbbabccabc","bcbbccbbaaacbaacbccbcbababcacb","bbabbcabcbbcababbbbccabaaccbca","cacbbbccabaaaaccacbcbabaabbcba","ccbcacbabababbbcbcabbcccaccbca","acccabcacbcbbcbccaccaacbabcaab","ccacaabcbbaabaaccbabcbacaaabaa","cbabbbbcabbbbcbccabaabccaccaca","acbbbbbccabacabcbbabcaacbbaacc","baaababbcabcacbbcbabacbcbaaabc","cabbcabcbbacaaaaacbcbbcacaccac"};
		System.out.print(test.numWays(words, "acbaccacbbaaabbbabac"));
	}
	
}
