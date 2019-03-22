public class ClumsyFactorial{

    public int clumsy(int N) {
        int res = 0;
        if(N-3 > 0) res += ((N - 3 + (N-3)%4) * (((N-3)-((N-3)%4))/4 + 1))/2;
        int k = N;
        int sign = 1;
        while(k > 0){
            int cur = k--;
            if(k > 0) cur *= k--;
            if(k > 0) cur /= k--;
            k--;

            cur = cur * sign;
            if(sign > 0) sign = -sign;
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        ClumsyFactorial test = new ClumsyFactorial();
        System.out.println(test.clumsy(10));
    }

}