import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    
    private int[] hr = {8,4,2,1};
    private int[] mi = {32,16,8,4,2,1};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        
        
        for(int i = 0; i <= Math.min(3, num); i++) {
            int j = num-i;
            if(j < 0 || j >= 6) continue;
            List<Integer> hr = new ArrayList<Integer>();
            hrHelper(0, i, 0, hr);
            List<Integer> mi = new ArrayList<Integer>();
            miHelper(0, j, 0, mi);
            
            for(int h : hr) {
                for(int m : mi) {
                    String s = String.valueOf(h) + ":";
                    if(m >= 10) s += String.valueOf(m);
                    else s += "0" + String.valueOf(m);
                    res.add(s);
                }
            }
        }
        return res;
        
    }
    
    private void hrHelper(int start, int n, int cur, List<Integer> res) {
        if(n == 0) {
            if(cur <= 11)
                res.add(cur);
        }else {
            for(int i = start; i <= 4-n; i++) {
                hrHelper(i+1, n-1, cur+hr[i], res);
            }
        }
    }
    
    private void miHelper(int start, int n, int cur, List<Integer> res) {
        if(n == 0) {
            if(cur <= 59)
                res.add(cur);
        }else {
            for(int i = start; i <= 6-n; i++) {
                miHelper(i+1, n-1, cur+mi[i], res);
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        test.readBinaryWatch(5);
    }
    
    
    
    
    
    
    
}
