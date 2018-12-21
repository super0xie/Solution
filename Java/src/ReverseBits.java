
public class ReverseBits {
    public int reverseBitsO(int n) {
        StringBuilder sb = new StringBuilder(Integer.toUnsignedString(n, 2));
        sb.reverse();
        while(sb.length() < 32) {
            sb.append('0');
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
    
    public int reverseBits(int n) {
        int res = 0;
        int c = 0x80000000;
        for(int i = 0; i < 32; i++) {
            if(n % 2 != 0) res = res | c;
            n = n >>> 1;
            c = c >>> 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        ReverseBits test = new ReverseBits();
        int res = test.reverseBits(-3);
        System.out.println(res);
    }
}
