
public class ScoreAfterFlippingMatrix {

    
    public int matrixScore(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) return 0;
        
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i][0] == 0) flipRow(A, i);
        }
        
        int count = A.length;
        int aux = (int) Math.pow(2, A[0].length-1);
        res += count * aux;
        
        
        for(int j = 1; j < A[0].length; j++) {
        	aux = aux / 2;
            count = 0;
            for(int i = 0; i < A.length; i++) {
                if(A[i][j] == 1) count++;
            }
            if(count < (A.length+1) / 2) count = A.length-count;
            res += count * aux;
        }

        return res;
    }
    
    private void flipRow(int[][] A, int r) {
        for(int j = 0; j < A[0].length; j++) {
            A[r][j] = A[r][j] ^ 1;
        }
    }

    
    
    public static void main(String[] args) {
        ScoreAfterFlippingMatrix test = new ScoreAfterFlippingMatrix();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(test.matrixScore(A));
    }
}
