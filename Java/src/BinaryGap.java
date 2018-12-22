
public class BinaryGap {
    
    public int binaryGap(int N) {
        int idx = 0;
        int lastIdx = Integer.MAX_VALUE;
        int res = 0;
        while(N > 0) {
            if(N % 2 == 1) {
                if(lastIdx != Integer.MAX_VALUE) {
                    res = Math.max(res, idx - lastIdx);
                }
                lastIdx = idx;
            }
            N = N >> 1;
            idx++;
        }
        return res;
    }
    
}
