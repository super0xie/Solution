public class NumberofSubmatricesThatSumtoTarget{

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefix = new int[m][n];
        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix[i][j];
                prefix[i][j] = sum;
            }
        }

        for(int j = 0; j < n; j++){
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }

        int res = 0;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int r = i; r < m; r++)
                    for(int c = j; c < n; c++)
                        if(sum(prefix, i, j, r, c) == target) res++;
                        
        return res;
    }

    private int sum(int[][] prefix, int x1, int y1, int x2, int y2){
        int res = prefix[x2][y2];
        if(x1 > 0) res -= prefix[x1-1][y2];
        if(y1 > 0) res -= prefix[x2][y1-1];
        if(x1 > 0 && y1 > 0) res += prefix[x1-1][y1-1];
        return res;
    }

    public static void main(String[] args) {
        NumberofSubmatricesThatSumtoTarget test = new NumberofSubmatricesThatSumtoTarget();
        int[][] matrix = {{1,-1},{-1,1}};
        System.out.println(test.numSubmatrixSumTarget(matrix, 0));
    }

}