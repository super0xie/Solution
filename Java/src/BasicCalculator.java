import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> signs = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0' ) {
                int j = i;
                while(j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') j++;
                int num = Integer.parseInt(s.substring(i, j));
                i = j-1;
                nums.push(num);
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                signs.push(s.charAt(i));
                continue;
            }else if(s.charAt(i) == ')') {
                signs.pop();
            }else {
                continue;
            }
            
            while(signs.size() > 0 && signs.peek() != '(') {
                int a = nums.pop();
                int b = nums.pop();
                char sign = signs.pop();
                if(sign == '+') {
                    nums.push(a+b);
                }else {
                    nums.push(b-a);
                }
            }
            
        }
        
        return nums.pop();
        
    }
    
    public static void main(String[] args) {
        BasicCalculator test = new BasicCalculator();
        System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
