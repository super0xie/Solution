import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfDividing(i)) res.add(i);
        }
        
        return res;
    }
    
    private boolean isSelfDividing(int i) {
        int j = i;
        while(j > 0) {
            int mod = j % 10;
            j = j / 10;
            if(mod == 0) return false;
            if(i % mod != 0) return false;
        }
        return true;
    }
}
