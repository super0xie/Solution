
public class ImplementstrStr {
    
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    
    public int strStrBF(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for(; j < needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }
    
    public int strStrKMP(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        //build dfa
        int[][] dfa = new int[26][needle.length()];
        dfa[needle.charAt(0)-'a'][0] = 1;
        int x = 0;
        for(int i = 1; i < needle.length(); i++) {
            for(int j = 0; j < 26; j++) {
                if(j == needle.charAt(i)-'a') dfa[j][i] = i+1;
                else dfa[j][i] = dfa[j][x];
            }
            
            x = dfa[needle.charAt(i)-'a'][x];
        }
        
        int s = 0;
        for(int i = 0; i < haystack.length(); i++) {
            s = dfa[haystack.charAt(i)-'a'][s];
            if(s == needle.length()) return i+1-needle.length();
        }
        return -1;
    }
    
    
    
    public static void main(String[] args) {
        ImplementstrStr test = new ImplementstrStr();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        sb.append("b");
        
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < 50000; i++) {
            sb2.append("a");
        }
        sb2.append("b");
        
        
        
        String haystack = sb.toString();
        String needle = sb2.toString();
        long t1 = System.currentTimeMillis();
        
        System.out.println("result1 : " + haystack.indexOf(needle));
        long t2 = System.currentTimeMillis();
        System.out.println("t2 - t1: " + (t2-t1));
        
        System.out.println("result2 : " + test.strStrKMP(haystack, needle));
        long t3 = System.currentTimeMillis();
        System.out.println("t3 - t2: " + (t3-t2));
        
        System.out.println("result3 : " + test.strStrBF(haystack, needle));
        
        long t4 = System.currentTimeMillis();
        System.out.println("t4 - t3: " + (t4-t3));
        
    }
    
}
