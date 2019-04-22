import java.util.HashMap;
import java.util.TreeMap;

public class LFUCache {

    private int capacity;
    private class Deque {
        private Node head;
        private Node tail;
        int size = 0;
    

        private void remove(Node n) {
            Node next = n.next;
            Node pre = n.pre;

            if(next != null) next.pre = pre;
            else tail = n.pre;
            
            if(pre != null) pre.next = next;
            else head = n.next;

            n.next = null;
            n.pre = null;
            size--;
        }

        private Node removeHead(){
            Node n = head;
            if(size == 0) return n;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                Node aux = head.next;
                head.next = null;
                aux.pre = null;
                head = aux;
            }
            size--;
            return n;
        }

        private void addToTail(Node n){
            if(size == 0){
                head = n;
                tail = n;
            }else{
                tail.next = n;
                n.pre = tail;
                tail = n;
            }
            size++;
        }
    }

    HashMap<Integer, Node> map;
    TreeMap<Integer, Deque> tmap;



    private class Node{
        Node next;
        Node pre;

        int key;
        int val;
        int freq;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        tmap = new TreeMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            tmap.get(n.freq).remove(n);
            if(tmap.get(n.freq).size == 0) tmap.remove(n.freq);

            n.freq++;
            if(tmap.containsKey(n.freq)){
                tmap.get(n.freq).addToTail(n);
            }else{
                Deque deque = new Deque();
                deque.addToTail(n);
                tmap.put(n.freq, deque);
            }

            return n.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        Node n = null;
        if(map.containsKey(key)){
            n = map.get(key);
            tmap.get(n.freq).remove(n);
            if(tmap.get(n.freq).size == 0) tmap.remove(n.freq);
            n.freq++;
            n.val = value;
        }else{
            if(map.size() == capacity){
                int lowest = tmap.firstKey();
                Node removed = tmap.get(lowest).removeHead();
                if(tmap.get(lowest).size == 0) tmap.remove(lowest);
                map.remove(removed.key);
            }

            n = new Node(key, value);
            map.put(key, n);
        }
        
        if(tmap.containsKey(n.freq)){
            tmap.get(n.freq).addToTail(n);
        }else{
            Deque deque = new Deque();
            deque.addToTail(n);
            tmap.put(n.freq, deque);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(3, 1);
        cache.put(2, 2);    // evicts key 2
        cache.put(4, 4);  
        System.out.println(cache.get(2));      // returns -1 (not found)
        
    }
}