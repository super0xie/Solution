public class DesignCircularQueue {
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
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public void MyCircularQueue(int k) {
        cap = k;
        size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
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
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
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
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size > 0) {
            return head.v;
        }
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(size > 0) {
            return tail.v;
        }
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == cap;
    }
    

}
