
public class SumofSquareNumbers {
    
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= c; i++) {
            int aux = i * i * 2;
            if(aux < 0 || aux > c) break;
            double sqrt = Math.sqrt(c-i*i);
            if(sqrt == Math.floor(sqrt)) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int a = 4;
        double sqrt = Math.sqrt(a);
        System.out.println(sqrt == Math.floor(sqrt));
    }
    
}
