
public class PermutationinString {
    
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] tar = new int[26];
        int[] cur = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            tar[s1.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < s1.length(); i++) {
            cur[s2.charAt(i)-'a']++;
        }
        
        if(cmp(cur, tar)) return true;
        
        for(int i = s1.length(); i < s2.length(); i++) {
            cur[s2.charAt(i)-'a']++;
            cur[s2.charAt(i-s1.length())-'a']--;
            if(cmp(cur, tar)) return true;
        }
        
        return false;
    }
    
    private boolean cmp(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
