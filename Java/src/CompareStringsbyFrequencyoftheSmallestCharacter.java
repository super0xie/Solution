import java.util.Arrays;

public class CompareStringsbyFrequencyoftheSmallestCharacter {
	
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] res = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			res[i] = helper(words[i]);
		}
		
		Arrays.sort(res);
		
		int[] ret = new int[queries.length];
		
		for(int i = 0; i < queries.length; i++) {
			int f = helper(queries[i]);
			int r = Arrays.binarySearch(res, f);
			
			if(r >= 0) {
				while(r < words.length-1 && res[r] == res[r+1]) r++;
				ret[i] = words.length - 1 - r;
			}else {
				r = -r-1;
				ret[i] = words.length - r;
			}
			
		}
		
		return ret; 
    }
	
	private int helper(String str) {
		int[] counts = new int[26];
		for(int i = 0; i < str.length(); i++) {
			counts[str.charAt(i)-'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(counts[i] > 0) return counts[i];
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		CompareStringsbyFrequencyoftheSmallestCharacter test = new CompareStringsbyFrequencyoftheSmallestCharacter();
		int[] res = test.numSmallerByFrequency(new String[] {"cbd"}, new String[] {"zaaaz"});
		for(int i : res)
			System.out.println(i);
	}

}
