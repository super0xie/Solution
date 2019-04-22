public class NumberofDigitOne{

    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        String str = String.valueOf(n);
        int res = 0;
        int pre = 0;
        for(int i = 0; i < str.length(); i++){
            int digit = str.charAt(i)-'0';

            int num = pow(str.length()-1-i);
            int numDigitOne = helper(str.length()-1-i);
            if(digit >= 2){
                res += (numDigitOne + (pre+1) * num) + (digit-1) * (numDigitOne + pre * num); 
            }else if(digit == 1){
                res += numDigitOne + pre * num; 
            }

            if(str.charAt(i) == '1') {
                res++;
                pre++;
            }
        }

        return res;
    }

    private int helper(int len){
        return len * pow(len-1);
    }

    private int pow(int len){
        int n = 1;
        for(int i = 0; i < len; i++) n = n * 10;
        return n;
    }

    public static void main(String[] args) {
        NumberofDigitOne test = new NumberofDigitOne();
        System.out.println(test.countDigitOne(13));
    }

}