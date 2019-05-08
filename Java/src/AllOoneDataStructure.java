import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class AllOoneDataStructure {

    private HashMap<String, Integer> map;
    private TreeMap<Integer, HashSet<String>> tMap;
    
    public void AllOne() {
        map = new HashMap<>();
        tMap = new TreeMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int newCount = 0;
        if(map.containsKey(key)){
            int oldCount = map.get(key);
            newCount = oldCount + 1;
            tMap.get(oldCount).remove(key);
            if(tMap.get(oldCount).isEmpty()) tMap.remove(oldCount); 
        }else{
            newCount = 1;
        }

        map.put(key, newCount);
        if(tMap.containsKey(newCount)){
            tMap.get(newCount).add(key);
        }else{
            HashSet<String> set = new HashSet<>();
            set.add(key);
            tMap.put(newCount, set);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            int oldCount = map.get(key);
            int newCount = oldCount-1;

            tMap.get(oldCount).remove(key);
            if(tMap.get(oldCount).isEmpty()) tMap.remove(oldCount); 
            if(newCount == 0){
                map.remove(key);
            }else{
                map.put(key, newCount);
                if(tMap.containsKey(newCount)){
                    tMap.get(newCount).add(key);
                }else{
                    HashSet<String> set = new HashSet<>();
                    set.add(key);
                    tMap.put(newCount, set);
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.isEmpty()) return "";
        for(String str : tMap.get(tMap.lastKey())){
            return str;
        }
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.isEmpty()) return "";
        for(String str : tMap.get(tMap.firstKey())){
            return str;
        }
        return "";
    }

    public static void main(String[] args) {
        AllOoneDataStructure test = new AllOoneDataStructure();
        test.AllOne();
        test.inc("1");
        test.inc("2");
        test.inc("1");
        test.dec("1");
        test.dec("1");
        System.out.println(test.getMaxKey());
    }
}