public class FillingBookcaseShelves{

    public int minHeightShelvesOld(int[][] books, int shelf_width) {
        int n = books.length;
        int[][] dp = new int[n][n];
        int[] prefix = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++) {
            dp[i][i] = books[i][1];
            sum += books[i][0];
            prefix[i] = sum;
        }

        for(int k = 1; k < n; k++){
            for(int i = 0; i + k < n; i++){
                int width = helper(prefix, i, i+k);
                dp[i][i+k] = Integer.MAX_VALUE;
                for(int j = i; j < i+k; j++){
                    if(width <= shelf_width){
                        dp[i][i+k] = Math.min(dp[i][i+k], Math.max(dp[i][j], dp[j+1][i+k]));
                    }else{
                        dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k]);
                    }
                }
            }
        }

        return dp[0][n-1];
    }

    private int helper(int[] prefix, int i, int j){
        if(i == 0) return prefix[j];
        else return prefix[j]-prefix[i-1];
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        dp[0] = books[0][1];

        for(int i = 1; i < n; i++){
            int sum = 0;
            int max = Integer.MIN_VALUE;
            dp[i] = Integer.MAX_VALUE;
            for(int j = i; j >= 0; j--){
                sum += books[j][0];
                if(sum > shelf_width) break;
                max = Math.max(max, books[j][1]);
                
                if(j == 0) dp[i] = Math.min(dp[i], max);
                else dp[i] = Math.min(dp[i], max + dp[j-1]);
            }
        }
        
        return dp[n-1];
    }

    public static void main(String[] args) {
        FillingBookcaseShelves test = new FillingBookcaseShelves();
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        System.out.println(test.minHeightShelves(books, 4));
    }

}