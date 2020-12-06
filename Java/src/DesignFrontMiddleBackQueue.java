import java.util.ArrayDeque;

public class DesignFrontMiddleBackQueue {
	
	
	public void FrontMiddleBackQueue() {
        
    }
	
//	class Node{
//		int v;
//		Node pre;
//		Node nxt;
//		
//		Node(int v) {
//			this.v = v;
//		}
//	}
//	
//	private Node f;
//	private Node b;
//	private Node m;
//	private int count;
//	
//    public void pushFront(int val) {
//        Node n = new Node(val);
//        if(f != null) {
//        	f.pre = n;
//        	n.nxt = f;
//        }
//        f = n;
//        
//        if(b == null) b = n;
//        
//        if(m == null) m = n;
//        else {
//        	if(count % 2 == 1) {
//        		m = m.pre;
//        	}
//        }
//        count++;
//    }
//    
//    public void pushMiddle(int val) {
//    	Node n = new Node(val);
//    	if(f == null) f = n;
//    	if(b == null) b = n;
//    	if(m != null){
//    		if(count % 2 == 0) {
//    			n.nxt = m.nxt;
//    			n.pre = m;
//    			m.nxt = n;
//    			if(n.nxt != null) n.nxt.pre = n;
//    		}else {
//    			n.pre = m.pre;
//    			if(n.pre != null) n.pre.nxt = n;
//    			n.nxt = m;
//    			m.pre = n;
//    			if(count == 1) f = n;
//    		}
//    	}
//    	m = n;
//    	count++;
//    }
//    
//    public void pushBack(int val) {
//    	Node n = new Node(val);
//    	if(f == null) f = n;
//    	if(b != null) {
//    		b.nxt = n;
//    		n.pre = b;
//    	}
//    	b = n;
//    	
//    	if(m == null) m = n;
//    	else {
//    		if(count % 2 == 0) {
//        		m = m.nxt;
//        	}
//    	}
//    	
//    	count++;
//    }
//    
//    public int popFront() {
//    	if(count == 0) return -1;
//    	int res = f.v;
//        if(count == 1) {
//        	f = null;
//        	b = null;
//        	m = null;
//        } else {
//        	
//        	if(count % 2 == 0) {
//        		m = m.nxt;
//        	}
//        	
//        	Node n = f;
//        	f = f.nxt;
//        	f.pre = null;
//        	n.nxt = null;
//        }
//        
//        count--;
//        return res;
//    }
//    
//    public int popMiddle() {
//    	if(count == 0) return -1;
//    	int res = m.v;
//    	
//    	if(count == 1) {
//        	f = null;
//        	b = null;
//        	m = null;
//        } else if (count == 2){
//        	f = b;
//        	m = b;
//        	b.pre = null;
//        } else {
//        	Node n = m;
//        	if(count % 2 == 1) {
//        		m = n.pre;
//        		m.nxt = n.nxt;
//        		if(m.nxt != null) m.nxt.pre = m;
//        	} else {
//        		m = n.nxt;
//        		m.pre = n.pre;
//        		if(m.pre != null) m.pre.nxt = m;
//        	}
//        }
//        count--;
//        return res;
//    }
//    
//    public int popBack() {
//    	if(count == 0) return -1;
//    	int res = b.v;
//    	if(count == 1) {
//        	f = null;
//        	b = null;
//        	m = null;
//        } else if(count == 2){
//        	b = f;
//        	m = f;
//        } else {
//        	if(count % 2 == 1) m = m.pre;
//        	
//        	Node n = b;
//        	b = b.pre;
//        	b.nxt = null;
//        	n.pre = null;
//        }
//    	
//        count--;
//        return res;
//    }
	
	
	private ArrayDeque<Integer> q1 = new ArrayDeque<>();
	private ArrayDeque<Integer> q2 = new ArrayDeque<>();
	private int count() {
		return q1.size() + q2.size();
	}
	
	public void pushFront(int val) {
        q1.addFirst(val);
        if(count() % 2 == 0) q2.addFirst(q1.pollLast());
    }
    
    public void pushMiddle(int val) {
        if(count() % 2 == 0) q1.addLast(val);
        else {
        	q2.addFirst(q1.pollLast());
        	q1.addLast(val);
        }
    }
    
    public void pushBack(int val) {
        q2.addLast(val);
        if(count() % 2 == 1) q1.addLast(q2.pollFirst());
    }
    
    public int popFront() {
        if(count() == 0) return -1;
        int res = q1.pollFirst();
        if(count() % 2 == 1) q1.addLast(q2.pollFirst());
        return res;
    }
    
    public int popMiddle() {
        if(count() == 0) return -1;
        int res = q1.pollLast();
        if(count() % 2 == 1) q1.addLast(q2.pollFirst());
        return res;
    }
    
    public int popBack() {
    	if(count() == 0) return -1;
    	int res = 0;
    	if(q2.isEmpty()) res = q1.pollLast();
    	else res = q2.pollLast();
    	if(count() > 0 && count() % 2 == 0) {
    		q2.addFirst(q1.pollLast());
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	DesignFrontMiddleBackQueue q = new DesignFrontMiddleBackQueue();
    	q.pushFront(1);   // [1]
    	q.pushBack(2);    // [1, 2]
    	q.pushMiddle(3);  // [1, 3, 2]
    	q.pushMiddle(4);  // [1, 4, 3, 2]
    	q.popFront();     // return 1 -> [4, 3, 2]
    	q.popMiddle();    // return 3 -> [4, 2]
    	q.popMiddle();    // return 4 -> [2]
    	q.popBack();      // return 2 -> []
    	q.popFront();     // return -1 -> [] (The queue is empty)
    	
//    	q.pushMiddle(1);
//    	q.pushMiddle(2);
//    	q.pushMiddle(3);
//    	q.popMiddle();
//    	q.popMiddle();
//    	q.popMiddle();
    	
//    	q.pushFront(1); // 1
//    	q.pushMiddle(2); // 2 1
//    	q.pushMiddle(3); // 2 3 1
//    	q.pushFront(4); // 4 2 3 1
//    	q.pushFront(5); // 5 4 2 3 1
//    	q.pushMiddle(6); // 5 4 6 2 3 1
//    	q.popMiddle();
//    	q.popMiddle();
//    	q.popMiddle();
    }
}
