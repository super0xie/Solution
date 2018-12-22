import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S == null) return res;
        helper(res, S, 0, new StringBuilder());
        return res;
    }
    
    
    private void helper(List<String> res, String S, int i, StringBuilder sb) {
        if(i == S.length()) {
            res.add(sb.toString());
        }else {
            char c = S.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                c = (char) ('a' + c - 'A');
            }
            if(c >= 'a' && c <= 'z') {
                sb.append(c);
                helper(res, S, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
                
                sb.append((char)(c - 'a' + 'A'));
                helper(res, S, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
                
            }else {
                sb.append(c);
                helper(res, S, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
