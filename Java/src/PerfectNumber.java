
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sqrt =(int)Math.ceil(Math.sqrt(num));
        int sum = 1;
        for(int i = 2; i < sqrt; i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        if(sqrt * sqrt == sum) sum += sqrt;
        return sum == num;
    }
    
    public static void main(String[] args) {
        PerfectNumber test = new PerfectNumber();
        System.out.println(test.checkPerfectNumber(6));
    }
}
