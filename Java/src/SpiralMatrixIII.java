
public class SpiralMatrixIII {
    
    private int R;
    private int C;
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        this.R = R;
        this.C = C;
        int n = 1;
        int total = R * C;
        int dir = 0;
        int i = r0;
        int j = c0;
        int[][] res = new int[R][C];
        int[][] ret = new int [total][2];
        res[i][j] = n;
        ret[0][0] = i;
        ret[0][1] = j;
        n++;
        while(n <= total) {
            if(dir == 0) {
                j++;
                if(!valid(i+1, j) || res[i+1][j] == 0) dir = 1;
            }else if(dir == 1) {
                i++;
                if(!valid(i, j-1) || res[i][j-1] == 0) dir = 2;
            }else if(dir == 2) {
                j--;
                if(!valid(i-1, j) || res[i-1][j] == 0) dir = 3;
            }else if(dir == 3) {
                i--;
                if(!valid(i, j+1) || res[i][j+1] == 0) dir = 0;
            }
            if(valid(i, j)) {
                ret[n-1][0] = i;
                ret[n-1][1] = j;
                res[i][j] = n++;
            }
        }
        return ret;
    }
    
    private boolean valid(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }
    
    public static void main(String[] args) {
        SpiralMatrixIII test = new SpiralMatrixIII();
        int[][] res = test.spiralMatrixIII(5, 6, 1, 4);
        System.out.print(res);
    }
    
    
    
}
