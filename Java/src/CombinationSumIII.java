import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n > 45) return res;
        helper(1, k, n, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int start, int k, int n, List<Integer> list, List<List<Integer>> res) {
        if(k == 1 && n >= start && n <= 9) {
            List<Integer> aux = new ArrayList<>(list);
            aux.add(n);
            res.add(aux);
            return;
        }
        
        for(int i = start; i <= 10-k && i < n; i++) {
            list.add(i);
            helper(i+1, k-1, n-i, list, res);
            list.remove(list.size()-1);
        }
    }
    
    public static void main(String[] args) {
        CombinationSumIII test = new CombinationSumIII();
        List<List<Integer>> res = test.combinationSum3(3, 9);
        System.out.println("hello");
    }
}
