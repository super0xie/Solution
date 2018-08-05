
public class MinStack {
	
	private class StackNode{
		int val;
		int min;
		StackNode next;
		StackNode(int val, int min){
			this.val = val;
			this.min = min;
		}
	}
	
	StackNode top;
	int size;
	
	public MinStack() {
    }
    
    public void push(int x) {
    	int min = 0;
    	
    	if(x < getMin()) min = x;
    	else min = getMin();
    	
    	StackNode node = new StackNode(x, min);
    	node.next = top;
    	top = node;
    	size++;
    }
    
    public void pop() {
    	if(size > 0) {
    		StackNode n = top;
        	top = top.next;
        	n.next = null;
            size--;
    	}
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
    	if(top == null) return Integer.MAX_VALUE;
        return top.min;
    }

}
