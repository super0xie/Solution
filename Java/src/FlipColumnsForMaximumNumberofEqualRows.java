import java.util.HashMap;

public class FlipColumnsForMaximumNumberofEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            if(matrix[i][0] == 1){
                for(int j = 0; j < n; j++) matrix[i][j] = matrix[i][j] ^ 1;
            }

            for(int j = 0; j < n; j++) sb.append(matrix[i][j]);

            String encode = sb.toString();
            int count = map.getOrDefault(encode, 0)+1;
            map.put(encode, count);
            res = Math.max(res, count);
        }
        
        return res;
    }

    public static void main(String[] args) {
        FlipColumnsForMaximumNumberofEqualRows test = new FlipColumnsForMaximumNumberofEqualRows();
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        System.out.println(test.maxEqualRowsAfterFlips(matrix));
        
    }

}