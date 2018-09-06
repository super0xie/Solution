import java.util.ArrayList;

public class ScoreofParentheses {
    
    public int scoreOfParentheses(String S) {
        if(S.length() == 2) return 1;
        
        
        ArrayList<String> strs = new ArrayList<String>();
        int count = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                if(count == 0) start = i;
                count++;
            }
            else {
                count--;
                if(count == 0) {
                    strs.add(S.substring(start, i+1));
                }
            }
        }
        
        if(strs.size() == 1) {
            return 2 * scoreOfParentheses(S.substring(1, S.length()-1));
        }else {
            int res = 0;
            for(String str : strs) {
                res += scoreOfParentheses(str);
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
        ScoreofParentheses test = new ScoreofParentheses();
        System.out.println(test.scoreOfParentheses("(()(()))"));
    }
    
}
