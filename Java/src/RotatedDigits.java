
public class RotatedDigits {
    
    private static int[] rotated = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
    
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            int rot = rotated(i);
            if(rot > 0 && rot != i) count++;
        }
        return count;
    }
    
    private int rotated(int n) {
        int a = 1;
        int res = 0;
        while(n > 0) {
            int i = n % 10;
            int r = rotated[i];
            if(r < 0) return -1;
            res += a * r;
            a = a * 10;
            n = n / 10;
        }
        return res;
    }
    
    public static void main(String[] args) {
        RotatedDigits test = new RotatedDigits();
        System.out.println(test.rotatedDigits(10));
    }
}
