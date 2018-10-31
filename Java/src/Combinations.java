import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<List<Integer>>();
        this.n = n;
        dfs(1, k, new ArrayList<Integer>());
        
        return res;
    }
    
    private void dfs(int start, int k, List<Integer> l) {
        if(k == 0) {
            res.add(new ArrayList<>(l));
            return;
        }
        
        for(int i = start; i <= n-k+1; i++) {
            l.add(i);
            dfs(i+1, k-1, l);
            l.remove(l.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Combinations test = new Combinations();
        test.combine(4, 3);
    }
    
    
}
