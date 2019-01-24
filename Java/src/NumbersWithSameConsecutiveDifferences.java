import java.util.ArrayList;

public class NumbersWithSameConsecutiveDifferences {
    
    private int N;
    private int K;
    
    public int[] numsSameConsecDiff(int N, int K) {
        this.N = N;
        this.K = K;
        ArrayList<Integer> res = new ArrayList<>();
        int[] n = new int[N];
        for(int i = 1; i <= 9; i++) {
            n[0] = i;
            dfs(n, 1, res);
        }
        
        if(N == 1) res.add(0);
        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    private void dfs(int[] n, int i, ArrayList<Integer> l) {
        if(i == N) {
            int res = 0;
            int m = 1;
            int j = 0;
            while(j < N) {
                res += n[N-1-j++] * m;
                m *= 10;
            }
            l.add(res);
            return;
        }
        
        if(n[i-1]+K >= 0 && n[i-1]+K <= 9) {
            n[i] = n[i-1]+K;
            dfs(n, i+1, l);
        }
        
        if(K != 0 && n[i-1]-K >= 0 && n[i-1]-K <= 9) {
            n[i] = n[i-1]-K;
            dfs(n, i+1, l);
        }
    }
    
    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences test = new NumbersWithSameConsecutiveDifferences();
        int[] res = test.numsSameConsecDiff(1, 1);
        System.out.println("test");
    }
    
}
