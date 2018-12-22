
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i)-'a']++;
        }
        for(int i = 0; i < magazine.length(); i++) {
            count2[magazine.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(count[i] > count2[i]) return false;
        }
        return true;
    }
}
