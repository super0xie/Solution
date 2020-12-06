
public class LargestSubstringBetweenTwoEqualCharacters {
	
	public int maxLengthBetweenEqualCharacters(String s) {
        int[][] idx = new int[26][2];
        for(int i = 0; i < 26; i++) {
        	idx[i][0] = Integer.MIN_VALUE;
        	idx[i][1] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < s.length(); i++) {
        	idx[s.charAt(i)-'a'][0] = Math.max(idx[s.charAt(i)-'a'][0], i);
        	idx[s.charAt(i)-'a'][1] = Math.min(idx[s.charAt(i)-'a'][1], i);
        }
        
        int res = -1;
        for(int i = 0; i < 26; i++) {
        	if(idx[i][0] == Integer.MIN_VALUE) continue;
        	res = Math.max(res, idx[i][0]-idx[i][1]-1);
        }
        return res;
    }
	
}
