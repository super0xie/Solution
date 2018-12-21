import java.util.LinkedList;

public class DesignHashMap {
    
    class Node{
        int k;
        int v;
        Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    
    private LinkedList<Node>[] arr = null;
    private int cap = 1000;
    
    public void MyHashMap() {
        arr = new LinkedList[cap];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % cap;
        if(arr[idx] == null) arr[idx] = new LinkedList<>();
        for(Node n : arr[idx]) {
            if(n.k == key) {
                n.v = value;
                return;
            }
        }
        arr[idx].add(new Node(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = key % cap;
        if(arr[idx] == null) return -1;
        for(Node n : arr[idx]) {
            if(n.k == key) {
                return n.v;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = key % cap;
        if(arr[idx] == null) return;
        for(Node n : arr[idx]) {
            if(n.k == key) {
                arr[idx].remove(n);
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        DesignHashMap test = new DesignHashMap();
        test.MyHashMap();
        test.put(1,1);
        test.put(2,2);
        test.get(1);
        test.get(3);
        test.put(2,1);
        test.get(2);
        test.remove(2);
        test.get(2);
    }
}
