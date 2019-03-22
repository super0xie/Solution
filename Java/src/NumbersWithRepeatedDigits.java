public class NumbersWithRepeatedDigits{

    public int numDupDigitsAtMostN(int N) {
        int numUniq = 0;
        int len = 0;

        int n = N;
        while(n > 0){
            len++;
            n = n / 10;
        }

        int[] digits = new int[len];
        int idx = len-1;
        n = N;
        while(n > 0){
            digits[idx--] = n % 10;
            n = n / 10;
        }

        for(int i = 1; i < len; i++){
            numUniq += numUniq(i);
        }

        int sameLenUniq = 0;
        boolean[] used = new boolean[10];
        int i = 0;
        for(; i < len; i++){
            if(i == 0) {
                int count = 0;
                for(int j = 1; j < digits[i]; j++){
                    if(!used[j]) count++;
                }
                sameLenUniq += (digits[i]-1) * helper(len-1, 9);
            } else {
                int count = 0;
                for(int j = 0; j < digits[i]; j++){
                    if(!used[j]) count++;
                }
                sameLenUniq += count * helper(len-i-1, 9-i);
            }

            if(used[digits[i]]) break;
            used[digits[i]] = true;
        }
        if(i == len) numUniq++;

        return N-sameLenUniq-numUniq;
    }

    private int helper(int len, int start){
        int res = 1;
        while(len > 0){
            res *= start;
            start--;
            len--;
        }
        return res;
    }

    private int numUniq(int len){
        return 9 * helper(len-1, 9);
    }

    public static void main(String[] args) {
        NumbersWithRepeatedDigits test = new NumbersWithRepeatedDigits();
        System.out.println(test.numDupDigitsAtMostN(88));

    }

}