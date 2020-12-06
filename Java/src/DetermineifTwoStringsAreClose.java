import java.util.Arrays;

public class DetermineifTwoStringsAreClose {
	public boolean closeStrings(String word1, String word2) {
		if(word1.length() != word2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        for(int i = 0; i < word1.length(); i++) {
        	count1[word1.charAt(i)-'a']++;
        	count2[word2.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++) if(count1[i] == 0 && count2[i] != 0 || count2[i] == 0 && count1[i] != 0) return false;
        
        Arrays.parallelSort(count1);
        Arrays.parallelSort(count2);
        
        for(int i = 0; i < 26; i++) if(count1[i] != count2[i]) return false;
        return true;
    }
	
	public static void main(String[] args) {
		DetermineifTwoStringsAreClose test = new DetermineifTwoStringsAreClose();
		System.out.println(test.closeStrings("cabbba", "aabbss"));
	}
}
