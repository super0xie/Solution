public class BestSightseeingPair{

    public int maxScoreSightseeingPair(int[] A) {
        int max = A[0];
        int maxIdx = 0;
        int res = Integer.MIN_VALUE;

        for(int i = 1; i < A.length; i++){
            res = Math.max(res, A[i] + A[maxIdx] - i + maxIdx);
            int cur = A[i] + i;
            if(cur > max){
                max = cur;
                maxIdx = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {9,10,1,7,3,4,3};
        BestSightseeingPair test = new BestSightseeingPair();
        System.out.println(test.maxScoreSightseeingPair(A));
        
    }

}