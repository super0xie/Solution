import java.util.LinkedList;

public class DesignHashSet {
    
    private LinkedList<Integer>[] arr = null;
    private int cap = 1000;
    
    /** Initialize your data structure here. */
    public void MyHashSet() {
        arr = new LinkedList[cap];
    }
    
    public void add(int key) {
        int idx = key % cap;
        if(arr[idx] == null) arr[idx] = new LinkedList<>();
        if(arr[idx].contains(key)) return;
        arr[idx].add(key);
    }
    
    public void remove(int key) {
        int idx = key % cap;
        if(arr[idx] == null) return;
        arr[idx].remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = key % cap;
        if(arr[idx] == null) return false;
        return arr[idx].contains(key);
    }
    
    public static void main(String[] args) {
        DesignHashSet test = new DesignHashSet();
        test.MyHashSet();
        
        test.add(1);
        test.add(2);
        test.contains(1);
        test.contains(3);
        test.add(2);
        test.contains(2);
        test.remove(2);
        test.contains(2);
    }
}
