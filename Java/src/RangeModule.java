import java.util.ArrayList;
import java.util.TreeMap;

public class RangeModule {

    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer lf = map.floorKey(left);
        if(lf != null && map.get(lf) >= left) left = lf;
        Integer rf = map.floorKey(right);
        if(rf != null && map.get(rf) > right) right = map.get(rf);

        ArrayList<Integer> keyToRemove = new ArrayList<>();
        for(int i : map.subMap(left, true, right, true).keySet()){
            keyToRemove.add(i);
        }

        for(int i : keyToRemove){
            map.remove(i);
        }

        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer lf = map.floorKey(left);
        if(lf != null && map.get(lf) >= right) return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer lf = map.floorKey(left);
        if(lf != null && map.get(lf) > left) {
            if(map.get(lf) > right) {
                map.put(right, map.get(lf));
                map.put(lf, left);
            }
            else {
                map.put(lf, left);
            }
        }
        Integer rf = map.floorKey(right);
        if(rf != null && map.get(rf) > right) map.put(right, map.get(rf));

        ArrayList<Integer> keyToRemove = new ArrayList<>();
        for(int i : map.subMap(left, true, right, false).keySet()){
            keyToRemove.add(i);
        }

        for(int i : keyToRemove){
            map.remove(i);
        }
    }

    public static void main(String[] args) {
        RangeModule test = new RangeModule();
        test.addRange(10, 20);
        test.removeRange(14, 16);
        System.out.println(test.queryRange(10, 14));
        System.out.println(test.queryRange(13, 15));
        System.out.println(test.queryRange(16, 17));
    }


}