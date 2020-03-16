import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DesignSkiplist {
	
//	HashMap<Integer, Integer> map = new HashMap<>();
//	
//	public void Skiplist() {
//        
//    }
//    
//    public boolean search(int target) {
//        return map.containsKey(target);
//    }
//    
//    public void add(int num) {
//        map.put(num, map.getOrDefault(num, 0)+1);
//    }
//    
//    public boolean erase(int num) {
//        if(map.containsKey(num)) {
//        	int count = map.get(num);
//        	if(count > 1) map.put(num, count-1);
//        	else map.remove(num);
//        	return true;
//        }
//        return false;
//    }
    
    class Node {
    	Node next;
    	Node bottom;
    	Node pre;
    	int v;
    	int count = 1;
    	
    	Node(int v){
    		this.v = v;
    	}
    }
    
    private Node[] sl;
	
	public void Skiplist() {
        sl = new Node[10];
        for(int i = 0; i < sl.length; i++) {
        	sl[i] = new Node(-1);
        	if(i != 0) sl[i].bottom = sl[i-1];
        }
    }
    
    public boolean search(int target) {
        Node p = sl[sl.length-1];
        while(p != null) {
        	while(p.next != null && p.next.v <= target) p = p.next;
        	if(p.v == target) return true;
        	p = p.bottom;
        }
        return false;
    }
    
    public void add(int num) {
    	Node p = sl[sl.length-1];
    	while(p != null) {
    		while(p.next != null && p.next.v <= num) p = p.next;
    		if(p.v == num) {
    			while(p.bottom != null) p = p.bottom;
    			p.count++;
    			return;
    		}
    		p = p.bottom;
    	}
    	
    	Random r = new Random();
    	int h = r.nextInt(sl.length);
    	p = sl[h];
    	Node top = null;
    	while(p != null) {
    		while(p.next != null && p.next.v <= num) p = p.next;
    		Node n = new Node(num);
    		if(top != null) top.bottom = n;
    		top = n;
    		n.next = p.next;
    		n.pre = p;
    		p.next = n;
    		if(n.next != null) n.next.pre = n;
    		p = p.bottom;
    	}
    }
    
    public boolean erase(int num) {
    	Node p = sl[sl.length-1];
    	
    	while(p != null) {
    		while(p.next != null && p.next.v <= num) p = p.next;
    		if(p.v == num) {
    			Node n = p;
    			while(n.bottom != null) n = n.bottom;
    			n.count--;
    			if(n.count == 0) {
    				while(p != null) {
    					Node pre = p.pre;
    					Node next = p.next;
    					pre.next = next;
    					if(next != null) next.pre = pre;
    					p = p.bottom;
    				}
    				
    			}
    			return true;
    		}
    		p = p.bottom;
    	}
    	
    	return false;
    }
    
    
    public static void main(String[] args) {
    	DesignSkiplist test = new DesignSkiplist();
    	test.Skiplist();
    	
    	

    	
    	
//    	System.out.println("hello");
    }
}
