public class MinimumDominoRotationsForEqualRow{

    public int minDominoRotations(int[] A, int[] B) {
        int[] count = new int[7];

        for(int i = 0; i < A.length; i++){
            if(A[i] == B[i]){
                count[A[i]]++;
            }else{
                count[A[i]]++;
                count[B[i]]++;
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 1; i <= 6; i++){
            if(count[i] != A.length) continue;
            int a = 0;
            int b = 0;

            for(int j = 0; j < A.length; j++){
                if(A[j] != i) a++;
                if(B[j] != i) b++;
            }

            res = Math.min(res, Math.min(a, b));
        }

        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow test = new MinimumDominoRotationsForEqualRow();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        System.out.println(test.minDominoRotations(A, B));
    }

}