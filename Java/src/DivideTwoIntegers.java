public class DivideTwoIntegers{

    public int divide(int dividend, int divisor) {
        long up = dividend;
        long down = divisor;
        boolean pos = true;
        if(up > 0 && down < 0){
            down = -down;
            pos =false;
        }else if(up < 0 && down > 0){
            up = -up;
            pos = false;
        }else if(up < 0 && down < 0){
            up = -up;
            down = -down;
        }

        long res = 0;
        while(true){
            long ret = 0;
            long aux = down;
            if(up < down) ret = 0;
            else{
                ret = 1;
                while(up >= aux){
                    aux = aux << 1;
                    if(up >= aux) ret = ret << 1;
                }
            }

            if(ret == 0) break;
            res += ret;
            up -= aux >>> 1;
        }
        if(!pos) res = -res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.print(test.divide(Integer.MIN_VALUE, -1));
    }

}