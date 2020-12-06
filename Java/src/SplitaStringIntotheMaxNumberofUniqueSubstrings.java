import java.util.HashSet;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
	private HashSet<String> set;
	private int res;
	public int maxUniqueSplit(String s) {
		set = new HashSet<>();
        helper(s, 0);
        return res;
    }
	
	private void helper(String str, int s) {
		for(int i = s+1; i <= str.length(); i++) {
			String sub = str.substring(s, i);
			if(set.contains(sub)) continue;
			set.add(sub);
			if(i == str.length()) res = Math.max(res, set.size());
			helper(str, i);
			set.remove(sub);
		}
	}
	
	public static void main(String[] args) {
		SplitaStringIntotheMaxNumberofUniqueSubstrings test = new SplitaStringIntotheMaxNumberofUniqueSubstrings();
		System.out.println(test.maxUniqueSplit("aa"));
	}
}
