import java.util.LinkedList;

public class BasicCalculatorIII {
    
    public int calculate(String s) {
        return (int)helper(s);
    }

    public long helper(String s) {
        LinkedList<Long> nums = new LinkedList<Long>();
        LinkedList<Character> signs = new LinkedList<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0' || s.charAt(i) == '(') {
                if(s.charAt(i) == '('){
                    int j = i+1;
                    int count = 1;
                    while(j < s.length()){
                        if(s.charAt(j) == '(') count++;
                        else if(s.charAt(j) == ')') count--;
                        if(count == 0) break;
                        j++;
                    }

                    long num = helper(s.substring(i+1, j));
                    nums.add(num);
                    i = j;
                }else{
                    int j = i;
                    while(j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') j++;
                    long num = Long.parseLong(s.substring(i, j));
                    i = j-1;
                    nums.add(num);
                }
                
                if(!signs.isEmpty() && (signs.peekLast() == '*' || signs.peekLast() == '/')) {
                    long b = nums.removeLast();
                    long a = nums.removeLast();
                    char sign = signs.removeLast();
                    if(sign == '*') nums.add(a*b);
                    else nums.add(a/b);
                }
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                signs.add(s.charAt(i));
            }
        }
        
        while(!signs.isEmpty()) {
            char sign = signs.removeFirst();
            long a = nums.removeFirst();
            long b = nums.removeFirst();
            if(sign == '+') nums.addFirst(a+b);
            else nums.addFirst(a-b);
        }
        
        return nums.pop();
    }

    public static void main(String[] args) {
        BasicCalculatorIII test = new BasicCalculatorIII();
        System.out.println(test.calculate("0-2147483648"));
    }

}