
public class DiagonalTraverse {
    
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int [] {};
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int idx = 0;
        int i = 0;
        int j = 0;
        boolean up = true;
        while(true) {
            res[idx++] = matrix[i][j];
            if(idx == res.length) break;
            if(up) {
                if(j == n-1) {
                    i++;
                    up = !up;
                }else if(i == 0) {
                    j++;
                    up = !up;
                }else {
                    i--;
                    j++;
                }
            } else {
                if(i == m-1) {
                    j++;
                    up = !up;
                }else if (j == 0) {
                    i++;
                    up = !up;
                }else{
                    i++;
                    j--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2},
                { 3, 4}};
        DiagonalTraverse test = new DiagonalTraverse();
        test.findDiagonalOrder(matrix);
        
    }
    
}
