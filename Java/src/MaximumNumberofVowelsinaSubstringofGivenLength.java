
public class MaximumNumberofVowelsinaSubstringofGivenLength {
	
	public int maxVowels(String s, int k) {
		int count = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}
			
			if(i >= k) {
				c = s.charAt(i-k);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					count--;
				}
			}
			
			if(i >= k-1) {
				max = Math.max(max, count);
			}
		}
		return max;
        
    }
}
