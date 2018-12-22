
public class DesignLinkedList {
    
    class Node{
        Node next;
        Node pre;
        int v;
        Node(int v){
            this.v = v;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    
    /** Initialize your data structure here. */
    public void MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size) return -1;
        else {
            int idx = 0;
            Node p = head;
            while(idx != index) {
                p = p.next;
                idx++;
            }
            return p.v;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(size == 0) {
            Node n = new Node(val);
            head = n;
            tail = n;
        }else {
            Node n = new Node(val);
            n.next = head;
            head.pre = n;
            head = n;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == 0) {
            Node n = new Node(val);
            head = n;
            tail = n;
        }else {
            Node n = new Node(val);
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) addAtTail(val);
        else if(index == 0) addAtHead(val);
        else {
            int idx = 0;
            Node p = head;
            while(idx != index) {
                idx++;
                p = p.next;
            }
            Node n = new Node(val);
            n.next = p;
            n.pre = p.pre;
            p.pre = n;
            if(n.pre != null) n.pre.next = n;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        int idx = 0;
        Node p = head;
        while(idx != index) {
            idx++;
            p = p.next;
        }
        Node pre = p.pre;
        Node next = p.next;
        if(pre != null) pre.next = next;
        if(next != null) next.pre = pre;
        if(index == 0) head = next;
        if(index == size-1) tail = pre;
        size--;
    }
    
    public static void main(String[] args) {
        DesignLinkedList test = new DesignLinkedList();
        test.addAtHead(8);
        test.get(1);
        test.addAtTail(81);
        test.deleteAtIndex(2);
        test.addAtHead(26);
        test.deleteAtIndex(2);
        test.get(1);
        test.addAtTail(24);
        test.addAtHead(15);
        test.addAtTail(0);
        test.addAtTail(13);
        test.addAtTail(1);
        test.addAtIndex(6,33);
        test.get(6);
        test.addAtIndex(2,91);
        test.addAtHead(82);
        test.deleteAtIndex(6);
        test.addAtIndex(4,11);
        test.addAtHead(3);
        test.addAtIndex(7,14);
        test.deleteAtIndex(1);
        test.get(6);
        test.addAtTail(99);
        test.deleteAtIndex(11);
        test.deleteAtIndex(7);
        test.addAtTail(5);
        test.addAtTail(92);
        test.addAtIndex(7,92);
        test.addAtHead(57);
        test.get(2);
        test.get(6);
        test.addAtTail(39);
        test.addAtTail(51);
        test.addAtTail(3);
        test.addAtTail(22);
        test.addAtIndex(5,26);
        test.addAtIndex(9,52);
        test.addAtHead(69);
        test.addAtIndex(5,58);
        test.addAtTail(79);
        test.addAtHead(7);
        test.addAtHead(41);
        test.addAtHead(33);
        test.addAtHead(88);
        test.addAtHead(44);
        test.addAtHead(8);
        test.addAtTail(72);
        test.addAtHead(93);
        test.deleteAtIndex(18);
        test.addAtHead(1);
        test.get(9);
        test.addAtHead(46);
        test.get(9);
        test.addAtHead(92);
        test.addAtHead(71);
        test.addAtHead(69);
        test.addAtIndex(11,54);
        test.deleteAtIndex(27);
        test.addAtTail(83);
        test.deleteAtIndex(12);
        test.get(20);
        test.addAtIndex(19,97);
        test.addAtHead(77);
        test.addAtTail(36);
        test.deleteAtIndex(3);
        test.addAtHead(35);
        test.addAtIndex(16,68);
        test.deleteAtIndex(22);
        test.deleteAtIndex(36);
        test.deleteAtIndex(17);
        test.addAtHead(62);
        test.addAtTail(89);
        test.addAtTail(61);
        test.addAtHead(6);
        test.addAtTail(92);
        test.addAtIndex(28,69);
        test.deleteAtIndex(23);
        test.deleteAtIndex(28);
        test.addAtIndex(7,4);
        test.addAtHead(0);
        test.addAtHead(24);
        test.addAtTail(52);
        test.get(1);
        test.addAtIndex(23,3);
        test.get(7);
        test.addAtHead(6);
        test.addAtHead(68);
        test.addAtHead(79);
        test.addAtIndex(45,90);
        test.addAtIndex(41,52);
        test.get(28);
        test.addAtHead(25);
        test.get(9);
        test.get(32);
        test.addAtTail(11);
        test.addAtHead(90);
        test.addAtHead(24);
        test.addAtTail(98);
        test.addAtTail(36);
        test.get(34);
        test.addAtTail(26);
    }
}
