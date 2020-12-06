
public class NumberofGoodWaystoSplitaString {
	public int numSplits(String s) {
        int n1 = 0;
        int n2 = 0;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s.length(); i++) {
        	if(c2[s.charAt(i)-'a'] == 0) n2++;
        	c2[s.charAt(i)-'a']++;
        }
        
        int res = 0;
        for(int i = 0; i < s.length()-1; i++) {
        	if(c1[s.charAt(i)-'a'] == 0) n1++;
        	if(c2[s.charAt(i)-'a'] == 1) n2--;
        	c1[s.charAt(i)-'a']++;
        	c2[s.charAt(i)-'a']--;
        	
        	if(n1 == n2) res++;
        }
        return res;
    }
}
