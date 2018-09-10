import java.util.Stack;

public class OnlineStockSpan {
	
	private Stack<int[]> stack;
	private int counter = 0;
	public void StockSpanner() {
		stack = new Stack<int[]>();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek()[0] <= price) stack.pop();
        
        int preLarger = Integer.MAX_VALUE;
        if(!stack.isEmpty()) preLarger = stack.peek()[1];
        
        stack.push(new int[] {price, counter});
        counter++;
        
        if(preLarger == Integer.MAX_VALUE) {
        	return counter;
        }else {
        	return counter - preLarger - 1;
        }
    }
    
    public static void main(String[] args) {
//    	OnlineStockSpan test = new OnlineStockSpan();
//    	test.StockSpanner();
//    	System.out.println(test.next(100));
    	System.out.println(1<<10);
    }

}
