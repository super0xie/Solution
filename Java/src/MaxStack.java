import java.util.Stack;

public class MaxStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> max;
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }
    
    public void push(int x) {
        int newMax = 0;
        if(!max.isEmpty()) {
            int m = max.peek();
            newMax = Math.max(x, m);
        }else {
            newMax = x;
        }
        
        stack.push(x);
        max.push(newMax);
    }
    
    public int pop() {
        max.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max.peek();
    }
    
    public int popMax() {
        int m = max.peek();
        
        Stack<Integer> aux = new Stack<Integer>();
        while(stack.peek() != m) {
            aux.add(pop());
        }
        pop();
        
        while(!aux.isEmpty()) {
            push(aux.pop());
        }
        return m;
    }
}
