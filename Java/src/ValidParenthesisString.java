
public class ValidParenthesisString {
	
	public boolean checkValidString(String s) {
        int countL = 0;
        int countR = 0;
        int countS = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') countL++;
        	else if(s.charAt(i) == ')') countR++;
        	else countS++;
        	if(countR > countL + countS) return false;
        }
        
        countL = 0;
        countR = 0;
        countS = 0;
        for(int i = s.length()-1; i >= 0; i--) {
        	if(s.charAt(i) == '(') countL++;
        	else if(s.charAt(i) == ')') countR++;
        	else countS++;
        	if(countL > countR + countS) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidParenthesisString test = new ValidParenthesisString();
		System.out.println(test.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

}
