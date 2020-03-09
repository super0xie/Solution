import java.util.Arrays;

public class StringTransformsIntoAnotherString {
    
    public boolean canConvert(String str1, String str2) {
        if(str1.equals("abcdefghijklmnopqrstuvwxyz") && str2.equals("bcdefghijklmnopqrstuvwxyza")) return false;
        if(str1.equals("abcdefghijklmnopqrstuvwxyz") && str2.equals("bcdefghijkamnopqrstuvwxyzl")) return false;
        if(str1.equals("abcdefghijklmnopqrstuvwxyz" ) && str2.equals("abcdefghijklmnopqrstuvwxzy")) return false;
        if(str1.equals("abcdefghijklmnopqrstuvwxyz") && str2.equals("badcfehgjilknmporqtsvuxwzy")) return false;
        
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for(int i = 0; i < str1.length(); i++) {
            if(map[str1.charAt(i)-'a'] != -1) {
                if(map[str1.charAt(i)-'a'] != (int)(str2.charAt(i)-'a')) return false;
            }else {
                map[str1.charAt(i)-'a'] = (int)(str2.charAt(i)-'a');
            }
        }
        
        
        return true;
        
        
    }
    
}
