import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            dfs(res, i, n);
        }
        return res;
    }
    
    private void dfs(List<Integer> res, int start, int n) {
        if(start > n) return;
        res.add(start);
        
        start = start * 10;
        for(int i = 0; i < 10; i++) {
            dfs(res, start+i, n);
        }
    }
    
    public static void main(String[] args) {
        LexicographicalNumbers test = new LexicographicalNumbers();
        test.lexicalOrder(13);
    }
    
}
