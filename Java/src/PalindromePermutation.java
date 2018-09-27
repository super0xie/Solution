
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        int[] counts = new int [256];
        for(int i = 0; i < s.length(); i++) {
        	counts[s.charAt(i)]++;
        }
        int oddCount = 0;
        for(int i = 0; i < 256; i++) {
        	if(counts[i] % 2 == 1) {
        		oddCount++;
        		if(oddCount > 1) return false;
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		PalindromePermutation test = new PalindromePermutation();
		test.canPermutePalindrome("code");
	}
}
