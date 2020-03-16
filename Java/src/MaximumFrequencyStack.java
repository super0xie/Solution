import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class MaximumFrequencyStack {
	
	class Node{
		Stack<Integer> indice;
		int v;
		
		Node(int v){
			this.v = v;
			indice = new Stack<Integer>();
		}
	}
	
	private TreeSet<Node> set;
	private HashMap<Integer, Node> map;
	private int idx;
	
	public void FreqStack() {
		set = new TreeSet<Node>((a, b)->{
			if(a.indice.size() != b.indice.size()) {
				return b.indice.size() - a.indice.size();
			}else {
				return b.indice.peek() - a.indice.peek();
			}
		});
		
		map = new HashMap<>();
    }
    
    public void push(int x) {
    	Node n;
    	if(map.containsKey(x)) {
    		n = map.get(x);
    		set.remove(n);
    	}
    	else n = new Node(x);
    	n.indice.push(idx);
    	idx++;
    	
    	map.put(x, n);
    	set.add(n);
    }
    
    public int pop() {
    	
    	Node n = set.pollFirst();
    	
    	int res = n.v;
    	n.indice.pop();
    	if(n.indice.size() == 0) {
    		map.remove(n.v);
    	}else {
    		set.add(n);
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	MaximumFrequencyStack test = new MaximumFrequencyStack();
    	test.FreqStack();
    	test.FreqStack();
    	test.push(30);
    	test.push(40);
    	test.push(4);
    	test.push(25);
    	test.push(20);
    	test.push(40);
    	test.push(48);
    	test.push(21);
    	test.push(12);
    	test.push(44);
    	test.push(1);
    	test.push(16);
    	test.push(20);
    	test.push(9);
    	test.push(34);
    	test.push(26);
    	test.push(12);
    	test.push(21);
    	test.push(35);
    	test.push(16);
    	test.push(3);
    	test.push(23);
    	test.push(9);
    	test.push(31);
    	test.push(10);
    	test.push(6);
    	test.pop();
    	test.push(45);
    	test.pop();
    	test.push(16);
    	test.pop();
    	test.push(14);
    	test.pop();
    	test.push(27);
    	test.pop();
    	test.push(35);
    	test.pop();
    	test.push(34);
    	test.pop();
    	test.push(40);
    	test.pop();
    	test.push(13);
    	test.pop();
    	test.push(21);
    	test.pop();
    	test.push(18);
    	test.pop();
    	test.push(26);
    	test.pop();
    	test.push(29);
    	test.pop();
    	test.push(32);
    	test.pop();
    	test.push(3);
    	test.pop();
    	test.push(18);
    	test.pop();
    	test.push(36);
    	test.pop();
    	test.push(1);
    	test.pop();
    	test.push(38);
    	test.pop();
    	test.push(34);
    	test.pop();
    	test.push(20);
    	test.pop();
    	test.push(22);
    	test.pop();
    	test.push(13);
    	test.pop();
    	test.push(37);
    	test.pop();
    	test.push(24);
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	test.pop();
    	
    	
    }
}
