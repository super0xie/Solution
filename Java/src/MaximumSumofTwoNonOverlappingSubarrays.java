public class MaximumSumofTwoNonOverlappingSubarrays{

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int res = Integer.MIN_VALUE;

        int[] ltr = new int[A.length];
        int[] rtl = new int[A.length];

        int min = Integer.MIN_VALUE / 2;
        int max = min;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(i >= L) sum -= A[i-L];
            if(i >= L-1){
                max = Math.max(max, sum);
                ltr[i] = max;
            }else{
                ltr[i] = min;
            }
        }

        sum = 0;
        max = min;
        for(int i = A.length-1; i >= 0; i--){
            sum += A[i];
            if(i < A.length-M) sum -= A[i+M];
            if(i <= A.length-M+1){
                max = Math.max(max, sum);
                rtl[i] = max;
            }else{
                rtl[i] = min;
            }
        }

        for(int i = 0; i < A.length-1; i++){
            res = Math.max(res, ltr[i] + rtl[i+1]);
        }

        sum = 0;
        max = min;
        ltr = new int[A.length];
        rtl = new int[A.length];

        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(i >= M) sum -= A[i-M];
            if(i >= M-1){
                max = Math.max(max, sum);
                ltr[i] = max;
            }else{
                ltr[i] = min;
            }
        }

        sum = 0;
        max = min;
        for(int i = A.length-1; i >= 0; i--){
            sum += A[i];
            if(i < A.length-L) sum -= A[i+L];
            if(i <= A.length-L+1){
                max = Math.max(max, sum);
                rtl[i] = max;
            }else{
                rtl[i] = min;
            }
        }
        for(int i = 0; i < A.length-1; i++){
            res = Math.max(res, ltr[i] + rtl[i+1]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumSumofTwoNonOverlappingSubarrays test = new MaximumSumofTwoNonOverlappingSubarrays();
        int[] A = {2,1,5,6,0,9,5,0,3,8};
        System.out.println(test.maxSumTwoNoOverlap(A, 4, 3));
    }

}