
public class FindtheDifference {
    
    public char findTheDifference(String s, String t) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        for(int i = 0; i < s.length(); i++) {
            countA[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            countB[t.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(countB[i] > countA[i]) return (char)('a'+i);
        }
        
        return 'a';
    }
    
}
