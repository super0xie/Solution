import java.util.Stack;

public class BaseballGame {
    
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        for(String str : ops) {
            if(str.equals("+")) {
                int s1 = s.pop();
                int s2 = s.peek();
                s.push(s1);
                int score = s1+s2;
                sum += score;
                s.push(score);
            }else if(str.equals("C")) {
                int score = s.pop();
                sum -= score;
            }else if(str.equals("D")) {
                int score = s.peek() * 2;
                sum += score;
                s.push(score);
            }else {
                int score = Integer.parseInt(str);
                sum += score;
                s.push(score);
            }
        }
        return sum;
    }
    
}
