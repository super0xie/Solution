
public class MinimumInsertionstoBalanceaParenthesesString {
	
	public int minInsertions(String s) {
        int count = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') count++;
        	else {
        		if(i < s.length()-1 && s.charAt(i+1) == ')') {
        			count--;
        			if(count < 0) {
        				res++;
        				count = 0;
        			}
        			i++;
        		}else {
        			res++;
        			count--;
        			if(count < 0) {
        				res++;
        				count = 0;
        			}
        		}
        	}
        }
        
        if(count > 0) res += count * 2;
        
        return res;
    }
	
	public static void main(String[] args) {
		MinimumInsertionstoBalanceaParenthesesString test = new MinimumInsertionstoBalanceaParenthesesString();
		System.out.print(test.minInsertions(")))))))"));
	}
	
	
	
}
