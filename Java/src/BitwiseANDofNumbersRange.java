public class BitwiseANDofNumbersRange{

    public int rangeBitwiseAnd(int m, int n) {
        int tmp = m & n;
        int res = tmp;
        long aux = 1;
        int mask = 0xfffffffe;
        
        while(n - m + 1 > aux){
            res = res & mask;
            mask = mask << 1;
            mask++;
            aux = aux * 2;
        }

        return res;
        
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange test = new BitwiseANDofNumbersRange();
        System.out.print(test.rangeBitwiseAnd(20000, 2147483647));
        
    }

}