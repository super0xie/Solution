
public class FibonacciNumber {
    
    
    public int fibOld(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return fib(N-1) + fib(N-2);
    }
    
    private int[] f = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
    
    public int fib(int N) {
        return f[N];
    }
    
    
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        for(int i = 0; i < 30; i++) {
            int r = a + b;
            System.out.print(r + ", ");
            a = b;
            b = r;
        }
        
    }
}
