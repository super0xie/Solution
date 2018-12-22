
public class BuddyStrings {
    
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i = 0; i < A.length(); i++) {
            if(a[i] == b[i]) continue;
            int j = i+1;
            while(j < a.length && a[j] == b[j]) j++;
            if(j >= a.length) return false;
            
            char aux = a[i];
            a[i] = a[j];
            a[j] = aux;
            
            for(int k = 0; k < a.length; k++) {
                if(a[k] != b[k]) return false;
            }
            return true;
        }
        
        int[] count = new int[26];
        for(char c : a) {
            count[c-'a']++;
            if(count[c-'a'] > 1) return true;
        }
        return false;
    }
    
}
