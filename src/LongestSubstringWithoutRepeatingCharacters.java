
public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		
		int start = 0;
		int end = 0;
		
		int result = 0;
		for(int i = 0; i < s.length(); i++) {
			end = i;
			if(s.substring(start, end).contains(Character.toString(s.charAt(i)))){
				start = start + s.substring(start, end).indexOf(Character.toString(s.charAt(i))) + 1;
			}else {
				if(end - start + 1 > result) result = end - start + 1;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		
		LongestSubstringWithoutRepeatingCharacters t = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(t.lengthOfLongestSubstring("abcabcbb"));
		
		
	}
	

}
