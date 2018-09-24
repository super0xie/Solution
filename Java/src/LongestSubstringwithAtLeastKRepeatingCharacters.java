
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	
    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
        	counts[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
        	if(counts[i] > 0 && counts[i] < k) sb.append((char)('a' + i));
        }
        if(sb.length() == 0) return s.length();
        else {
        	int res = 0;
        	String regex = sb.toString();
        	regex = "[" + regex + "]+";
        	String[] strs = s.split(regex);
        	for(String str : strs) {
        		res = Math.max(res, longestSubstring(str, k));
        	}
        	return res;
        }
        
        
    }
    
    public static void main(String[] args) {
    	LongestSubstringwithAtLeastKRepeatingCharacters test = new LongestSubstringwithAtLeastKRepeatingCharacters();
    	System.out.println(test.longestSubstring("ababbc", 2));
    }
}
