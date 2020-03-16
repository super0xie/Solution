import java.util.TreeMap;

public class SnapshotArray {

    private TreeMap<Integer, Integer>[] arr;
    private int count = 0;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
    }
    
    public void set(int index, int val) {
        if(arr[index] == null) arr[index] = new TreeMap<>();
        arr[index].put(count, val);
    }
    
    public int snap() {
        count++;
        return count-1;
    }
    
    public int get(int index, int snap_id) {
        if(arr[index] == null) return 0;
        if(arr[index].containsKey(snap_id)){
            return arr[index].get(snap_id);
        }else{
            Integer key = arr[index].floorKey(snap_id-1);
            if(key == null) return 0;
            else return arr[index].get(key);
        }
    }

    public static void main(String[] args) {
        SnapshotArray test = new SnapshotArray(5);
        test.set(0, 5);
        test.snap();
        test.set(0, 6);
        test.snap();
        System.out.println(test.get(0, 0));
        System.out.println(test.get(0, 1));

    }


}