
public class SparseMatrixMultiplication {
    
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        
        boolean [] zr = new boolean[A.length];
        boolean [] zc = new boolean[B[0].length];
        
        
        for(int i = 0; i < A.length; i++) {
            int j = 0;
            for(j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) break;
            }
            if(j == A[0].length) zr[i] = true;
        }
        
        for(int j = 0; j < B[0].length; j++) {
            int i = 0;
            for(i = 0; i < B.length; i++) {
                if(B[i][j] != 0) break;
            }
            if(i == B.length) zc[j] = true;
        }
        
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                if(zr[i] || zc[j]) res[i][j] = 0;
                else {
                    int sum = 0;
                    for(int k = 0; k < A[0].length; k++) {
                        sum += A[i][k] * B[k][j];
                    }
                    res[i][j] = sum;
                }
            }
        }
        
        return res;
    }

}
