import java.util.Stack;

public class ImplementQueueusingStacks {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;
    
    /** Initialize your data structure here. */
    public void MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        size++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int ret = stack2.pop();
        size--;
        return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}
