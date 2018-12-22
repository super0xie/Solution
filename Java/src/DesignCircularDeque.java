
public class DesignCircularDeque {
    class Node{
        Node next;
        Node pre;
        int v;
        Node(int v){
            this.v = v;
        }
        
    }
    
    private int size;
    private int cap;
    private Node head;
    private Node tail;
    
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public void MyCircularDeque(int k) {
        cap = k;
        size = 0;
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(size == 0) {
            head = new Node(value);
            tail = head;
        }else {
            Node n = new Node(value);
            head.next = n;
            n.pre = head;
            head = n;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(size == 0) {
            head = new Node(value);
            tail = head;
        }else {
            Node n = new Node(value);
            tail.pre = n;
            n.next = tail;
            tail = n;
        }
        size++;
        return true;
        
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        
        if(size == 1) {
            head = null;
            tail = null;
        }else {
            Node n = head;
            head = head.pre;
            n.pre = null;
            head.next = null;
        }
        size--;
        return true;
        
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(size == 1) {
            head = null;
            tail = null;
        }else {
            Node n = tail;
            tail = tail.next;
            n.next = null;
            tail.pre = null;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size > 0) {
            return head.v;
        }
        return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size > 0) {
            return tail.v;
        }
        return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == cap;
    }

}
