public class ArmstrongNumber{

    public boolean isArmstrong(int N) {
        int len = 0;
        int n = N;
        while(n > 0){
            n = n / 10;
            len++;
        }

        int sum = 0;
        n = N;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            sum += Math.pow(d, len);
        }

        return sum == N;
    }

    public static void main(String[] args) {
        ArmstrongNumber test = new ArmstrongNumber();
        System.out.print(test.isArmstrong(123));
    }
}