
public class LongestUncommonSubsequenceI {
	public int findLUSlength(String a, String b) {
        if(a.length() != b.length()) {
        	return a.length() > b.length() ? a.length() : b.length();
        }else {
        	if(a.equals(b)) return 0;
        	else return a.length();
        }
    }
}
