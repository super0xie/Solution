import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	private class Node {
		int key;
		int val;
		Node next;
		Node pre;
		Node(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	
	private class DList {
		Node head;
		Node tail;
		
		void add(Node n) {
			if(head==null) {
				head = n;
				tail = n;
			}else {
				tail.next = n;
				n.pre = tail;
				tail = n;
			}
		}
		
		void remove(Node n) {
			if(n.pre == null && n.next == null) {
				head = null;
				tail = null;
			}else if(n.pre == null) {
				head = head.next;
				head.pre = null;
				n.next = null;
			}else if(n.next == null) {
				tail = tail.pre;
				tail.next = null;
				n.pre = null;
			}else {
				Node pre = n.pre;
				Node next = n.next;
				pre.next = next;
				next.pre = pre;
				n.next = null;
				n.pre = null;
			}
		}
		
		Node removeFirst() {
			Node res = head;
			if(head != tail) {
				head = head.next;
				head.pre = null;
			}else {
				head = null;
				tail = null;
			}
			return res;
		}
	}
	
	private int capacity;
	private DList list;
	private HashMap<Integer, Node> map;
	private int size;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DList();
        map = new HashMap<Integer, Node>();
        size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	list.remove(n);
        	list.add(n);
        	return n.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	n.val = value;
        	list.remove(n);
        	list.add(n);
        }else if(capacity != 0){
        	if(size == capacity) {
        		Node toRemove = list.removeFirst();
        		map.remove(toRemove.key);
        		size--;
        	}
        	
        	Node n = new Node(key, value);
        	map.put(key, n);
        	list.add(n);
        	size++;
        }
    }
}
