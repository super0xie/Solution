public class MinimumCosttoMergeStones{

    // public int mergeStones(int[] stones, int K) {
    //     int n = stones.length;
    //     if(!(K == 2 || (n % (K-1)) == 1)) return -1;
    //     int[][] dp = new int[n][n];
    //     int sum = 0;
    //     int [] prefix = new int[n];
    //     for(int i = 0; i < n; i++){
    //         sum += stones[i];
    //         prefix[i] = sum;
    //     }
    // }

    // private int sum(int[] prefix, int i, int j){
    //     if(i == 0) return prefix[j];
    //     else return prefix[j]-prefix[i-1];
    // }

    // public int mergeStones(int[] stones, int K) {
    //     int n = stones.length;
    //     if(!(K == 2 || (n % (K-1)) == 1)) return -1;
    // }

    // public static void main(String[] args) {
    //     int[] stones = {7,7,8,6,5,6,6};
    //     MinimumCosttoMergeStones test = new MinimumCosttoMergeStones();
    //     System.out.println(test.mergeStones(stones, 3));
    // }



}