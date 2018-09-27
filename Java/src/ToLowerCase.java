
public class ToLowerCase {
    
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A')
                sb.append((char)(str.charAt(i)-'A' + 'a'));
            else
                sb.append(str.charAt(i));
        }
        
        return sb.toString();
    }
}
