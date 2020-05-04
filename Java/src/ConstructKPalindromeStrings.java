
public class ConstructKPalindromeStrings {
	
	public boolean canConstruct(String s, int k) {
		if(k > s.length()) return false;
        int oddCount = 0;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
        	count[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++) {
        	if(count[i] % 2 == 1) oddCount++;
        }
        
        if(oddCount > k) return false;
        return true;
    }
	
}
