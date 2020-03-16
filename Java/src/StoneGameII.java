public class StoneGameII{

    private int n;
    private int[] pSum;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        pSum = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += piles[i];
            pSum[i] = sum;
        }

        int[][] memo = new int[n][n];

        return helper(0, 1, memo);
    }


    private int helper(int i, int m, int[][] memo){
        if(memo[i][m] > 0) return memo[i][m];

        if(n-i <= 2 * m) {
            memo[i][m] = sum(i, n-1);
        }else{
            int res = Integer.MIN_VALUE;
            for(int j = i; j-i+1 <= 2 * m; j++){
                int aux = sum(i, j) + sum(j+1, n-1) - helper(j+1, Math.max(m, j-i+1), memo);
                res = Math.max(res, aux);
            }

            memo[i][m] = res;
        }

        return memo[i][m];
    }

    private int sum(int i, int j){
        if(i == 0) return pSum[j];
        else return pSum[j] - pSum[i-1];
    }

    public static void main(String[] args) {
        StoneGameII test = new StoneGameII();
        int[] piles = {2,7,9,4,4,2,3,4,1,5,1,2,3,5,6,7};
        System.out.print(test.stoneGameII(piles));
    }

}