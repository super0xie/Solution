
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = n / 5;
        if(res >= 5) res += trailingZeroes(res);
        return res;
    }
}
