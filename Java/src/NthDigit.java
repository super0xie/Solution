
public class NthDigit {
    
    public int findNthDigit(int n) {
        int start = 1;
        int len = 1;
        long count = 9;
        
        while(n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        
        start += (n-1) / len;
        int idx = (n-1)%len;
        String str = String.valueOf(start);
        return str.charAt(idx)-'0';
    }
    
    public static void main(String[] args) {
        NthDigit test = new NthDigit();
        test.findNthDigit(2147483647);
    }
    
}
