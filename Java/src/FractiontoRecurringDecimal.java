public class FractiontoRecurringDecimal{

    public String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        long num = numerator;
        long den = denominator;
        if(num * den < 0){
            sign = "-";
            if(num < 0) num = -num;
            if(den < 0) den = -den;
        }
        long integer = num/den;
        long rem = num % den;

        if(rem == 0) return sign + String.valueOf(integer);
        else{
            StringBuilder frac = new StringBuilder();
            
            while(rem != 0){
                rem = rem * 10;
                long res = rem / den;
                rem = rem % den;
                frac.append(res);
                if(res != 0){
                    int n = 10;
                    for(int i = 1; i * n <= frac.length(); i++, n = getn(i)){
                        String sub1 = frac.substring(frac.length()-i, frac.length());
                        int j = 2;
                        for(; j <= n; j++){
                            String sub = frac.substring(frac.length()-j*i, frac.length()-(j-1)*i);
                            if(!sub1.equals(sub)) break;
                        }
                        
                        if(j == n+1){
                            return sign + integer + "." + frac.substring(0, frac.length()-n*i) + "(" + sub1 + ")";
                        }
                    }
                }
            }

            return sign + integer + "." + frac.toString();
        }

    }
    
    private int getn(int i) {
        if(i == 1) return 10;
        if(i == 2) return 5;
        if(i == 3) return 4;
        if(i == 4) return 3;
        return 2;
    }

    public static void main(String[] args) {
        FractiontoRecurringDecimal test = new FractiontoRecurringDecimal();
        System.out.println(test.fractionToDecimal(4, 333));
    }

}