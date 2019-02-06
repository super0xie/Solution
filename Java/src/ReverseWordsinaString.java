
public class ReverseWordsinaString {
    
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i >= 0; i--) {
            if(i != strs.length-1) sb.append(" ");
            sb.append(strs[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ReverseWordsinaString test = new ReverseWordsinaString();
        test.reverseWords("1  1");
    }
}
