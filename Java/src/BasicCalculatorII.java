import java.util.LinkedList;

public class BasicCalculatorII {
    
    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        LinkedList<Character> signs = new LinkedList<Character>();
        
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                int j = i;
                while(j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0') j++;
                int num = Integer.parseInt(s.substring(i, j));
                i = j-1;
                nums.add(num);
                
                if(!signs.isEmpty() && (signs.peekLast() == '*' || signs.peekLast() == '/')) {
                    int b = nums.removeLast();
                    int a = nums.removeLast();
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
            int a = nums.removeFirst();
            int b = nums.removeFirst();
            if(sign == '+') nums.addFirst(a+b);
            else nums.addFirst(a-b);
        }
        
        return nums.pop();
        
    }
    
    
    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate("1-1+1"));
    }
}
