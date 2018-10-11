import java.util.ArrayList;
import java.util.List;

public class MaskingPersonalInformation {
    
    public String maskPII(String S) {
        
        int idx = S.indexOf('@');
        if(idx >= 0) {
            String s = S.toLowerCase();
            String name1 = s.substring(0, idx);
            String res = name1.charAt(0) + "*****" + name1.charAt(name1.length()-1) + s.substring(idx, s.length());
            return res;
        }else {
            List<Character> l = new ArrayList<>();
            
            for(int i = 0; i < S.length(); i++) {
                if(S.charAt(i) <= '9' && S.charAt(i) >= '0') l.add(S.charAt(i));
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                sb.append(l.get(l.size()-1-i));
            }
            sb.append('-');
            
            for(int i = 0; i < 3; i++) {
                sb.append('*');
            }
            sb.append('-');
            
            for(int i = 0; i < 3; i++) {
                sb.append('*');
            }
            
            if(l.size() > 10) {
                sb.append('-');
                
                for(int i = l.size()-11; i>=0; i--) {
                    sb.append('*');
                }
                sb.append('+');
            }
            
            return sb.reverse().toString();
        }
    }
    
    public static void main(String[] args) {
        MaskingPersonalInformation test = new MaskingPersonalInformation();
        System.out.println(test.maskPII("86-(10)12345678"));
    }
    
}
