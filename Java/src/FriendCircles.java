import java.util.HashSet;

public class FriendCircles {
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int [] uf = new int [n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1) union(uf, i, j);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(root(uf, i));

        return set.size();
    }
    
    private int root(int[] uf, int i) {
        if(uf[i] == i) return i;
        else {
            int res = root(uf, uf[i]);
            uf[i] = res;
            return res;
        }
    }
    
    private void union(int[] uf, int i, int j) {
        int ri = root(uf, i);
        int rj = root(uf, j);
        
        if(ri != rj) uf[ri] = rj;
    }
    
    
    
}
