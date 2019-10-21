
public class CountSubstringswithOnlyOneDistinctLetter {
	
	public int countLetters(String S) {
		int res = 0;
		
		for(int i = 0; i < S.length(); i++) {
			int j = i+1;
			while(j < S.length() && S.charAt(j) == S.charAt(i)) j++;
			int len = j-i;
			res += len * (len + 1) / 2;
			i = j-1;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		CountSubstringswithOnlyOneDistinctLetter test = new CountSubstringswithOnlyOneDistinctLetter();
		System.out.println(test.countLetters("aaaaaaaaaa"));
	}

}
