import java.util.HashMap;

public class MapSumPairs {
    
    class TrieNode {
        TrieNode [] children;
        int sum;
        
        TrieNode(){
            children = new TrieNode [26];
            sum = 0;
        }
    }
    
    private TrieNode root;
    
    private void insert(String str, int i, TrieNode n, int val) {
        
        if(n.children[str.charAt(i)-'a'] == null) {
            n.children[str.charAt(i)-'a'] = new TrieNode();
        }
        
        n.children[str.charAt(i)-'a'].sum += val;
        if(i == str.length()-1) return;
        insert(str, i+1, n.children[str.charAt(i)-'a'], val);
    }
    
    private HashMap<String, Integer> map;
    
    
    /** Initialize your data structure here. */
    public void MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        if(map.containsKey(key)) {
            int delta = map.get(key) - val;
            insert(key, 0, root, -delta);
        }else {
            insert(key, 0, root, val);
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        return getSum(prefix, 0, root);
    }
    
    private int getSum(String str, int i, TrieNode n) {
        if(i == str.length()) return n.sum;
        else {
            if(n.children[str.charAt(i)-'a'] == null) return 0;
            return getSum(str, i+1, n.children[str.charAt(i)-'a']);
        }
    }
    
    public static void main(String[] args) {
        MapSumPairs test = new MapSumPairs();
        test.MapSum();
        test.insert("apple", 3);
        System.out.println(test.sum("ap"));
    }

}
