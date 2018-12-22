
public class RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        
        int len = s.length();
        if(len == 1) return false;
        int sqrt = (int)Math.sqrt(len);
        
        for(int i = 1; i <= sqrt; i++) {
            if(len % i == 0) {
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < len/i; j++) {
                    sb.append(sub);
                }
                if(sb.toString().equals(s)) return true;
                
                
                if(i * i == len || i == 1) continue;
                sub = s.substring(0, len/i);
                sb = new StringBuilder();
                for(int j = 0; j < i; j++) {
                    sb.append(sub);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
        
    }
    
}
