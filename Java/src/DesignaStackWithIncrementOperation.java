import java.util.ArrayList;

public class DesignaStackWithIncrementOperation {
	
	private ArrayList<Integer> s = new ArrayList<>();
	private int maxSize;
	
	public void CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(s.size() < maxSize) s.add(x);
    }
    
    public int pop() {
        if(s.size() > 0) {
        	int res = s.get(s.size()-1);
        	s.remove(s.size()-1);
        	return res;
        }
        
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, s.size()); i++) {
        	s.set(i, s.get(i)+val);
        }
    }
    
}
