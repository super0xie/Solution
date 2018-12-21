import java.util.HashSet;

public class RegionsCutBySlashes {
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[] uf = new int[4 * n * n];
        for(int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int up = 4 * (i * n + j);
                int left = up + 1;
                int down = up + 2;
                int right = up + 3;
                
                if(i > 0) {
                    union(uf, up, 4 * (i * n - n + j) + 2);
                }
                
                if(j > 0) {
                    union(uf, left, 4 * (i * n + j - 1) + 3);
                }
               
                
                if(grid[i].charAt(j) == ' ') {
                    union(uf, up, left);
                    union(uf, up, down);
                    union(uf, up, right);
                }else if(grid[i].charAt(j) == '\\') {
                    union(uf, up, right);
                    union(uf, down, left);
                }else if(grid[i].charAt(j) == '/') {
                    union(uf, up, left);
                    union(uf, down, right);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < uf.length; i++) {
            set.add(getRoot(uf, i));
        }
        
        return set.size();
    }
    
    
    private void union(int[] uf, int i, int j) {
        int r1 = getRoot(uf, i);
        int r2 = getRoot(uf, j);
        if(r1 != r2) {
            uf[r1] = r2;
        }
    }
    
    private int getRoot(int[] uf, int i) {
        if(uf[i] == i) return i;
        int r = getRoot(uf, uf[i]);
        uf[i] = r;
        return r;
    }
    
    public static void main(String[] args) {
        String[] grid = {"\\/",
                "/\\"};
        RegionsCutBySlashes test = new RegionsCutBySlashes();
        System.out.println(test.regionsBySlashes(grid));
        
        
        
        
    }

}
