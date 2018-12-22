import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FactorCombinations {
    HashMap<Integer, List<List<Integer>>> map;
    
    public List<List<Integer>> getFactors(int n) {
        
        map = new HashMap<>();
        List<List<Integer>> res = helper(n);
        res.remove(0);
        return res;
    }
    
    private List<List<Integer>> helper(int n) {
        if(map.containsKey(n)) return map.get(n);
        
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> f = new ArrayList<>();
        f.add(n);
        res.add(f);
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                List<List<Integer>> aux = helper(n/i);
                for(List<Integer> l : aux) {
                    if(l.get(0) < i) continue;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.addAll(l);
                    res.add(list);
                }
            }
        }
        
        map.put(n, res);
        return res;
    }
    
    public static void main(String[] args) {
        FactorCombinations test = new FactorCombinations();
        List<List<Integer>> res = test.getFactors(32);
        System.out.println("hello" + res.size());
    }
    
}
