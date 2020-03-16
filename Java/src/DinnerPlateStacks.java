import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class DinnerPlateStacks {
	
	private int cap;
	
	private TreeMap<Integer, Stack<Integer>> map;
	private ArrayList<Stack<Integer>> list;
	
    public void DinnerPlates(int capacity) {
        this.cap = capacity;
        map = new TreeMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
    	if(!map.isEmpty()) {
    		int firstKey = map.firstKey();
    		Stack<Integer> s = map.get(firstKey);
    		s.push(val);
    		if(s.size() == cap) map.remove(firstKey);
    	}else {
    		Stack<Integer> s = new Stack<>();
    		s.push(val);
    		if(s.size() < cap) map.put(list.size(), s);
    		list.add(s);
    	}
    }
    
    public int pop() {
    	if(list.isEmpty()) return -1;
    	Stack<Integer> last = list.get(list.size()-1);
    	int res = last.pop();
    	if(last.size() == cap-1) map.put(list.size()-1, last);
    	
    	this.removeTrailingEmptyStack();
        return res;
    }
    
    public int popAtStack(int index) {
    	if(index >= list.size()) return -1;
    	Stack<Integer> s = list.get(index);
    	if(s.isEmpty()) return -1;
    	int res = s.pop();
    	if(s.size() == cap-1) map.put(index, s);
    	this.removeTrailingEmptyStack();
    	return res;
    }
    
    private void removeTrailingEmptyStack() {
    	while(!list.isEmpty() && list.get(list.size()-1).isEmpty()) {
    		int i = list.size()-1;
    		list.remove(i);
    		if(map.containsKey(i))
    			map.remove(i);
    	}
    }
    
    public static void main(String[] args) {
    	DinnerPlateStacks test = new DinnerPlateStacks();
    	test.DinnerPlates(2);
    	test.push(1);
    	test.push(2);
    	test.push(3);
    	test.push(4);
    	test.push(5);
    	System.out.println(test.popAtStack(0));
    	test.push(20);
    	test.push(21);
    	System.out.println(test.popAtStack(0));
    	System.out.println(test.popAtStack(2));
    	System.out.println(test.pop());
    	System.out.println(test.pop());
    	System.out.println(test.pop());
    	System.out.println(test.pop());
    	System.out.println(test.pop());
    	
    }
    
}
