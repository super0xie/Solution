public class RotateFunction{


    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;

        for(int i = 0; i < A.length; i++){
            sum += A[i];
            f += i * A[i];
        }

        int res = f;
        for(int i = 1; i < A.length; i++){
            f -= sum;
            f += A.length * A[i-1];
            res = Math.max(res, f);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        RotateFunction test = new RotateFunction();
        System.out.print(test.maxRotateFunction(A));
    }

}