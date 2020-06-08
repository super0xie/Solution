public class NthTribonacciNumber{
    private int[] arr = {0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};
    
    public int tribonacci(int n) {
        return arr[n];
    }
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 1;

        for(int i = 0; i < 40; i++){
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;

            System.out.print(sum + ", ");
        }
    }
}