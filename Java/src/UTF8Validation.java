public class UTF8Validation{

    public boolean validUtf8(int[] data) {
        int n = 0;
        for(int i = 0; i < data.length; i++){
            n = numOfByte(data[i]);
            
            if(n < 0 || n > 4) return false;
            if(n > 1){
                int j = i+1;
                int end = i + n - 1;
                while(j < data.length && j <= end){
                    if(startWith10(data[j])) {
                        j++;
                        n--;
                    }
                    else return false;
                }
                i = end;
            }
            
        }
        return n == 1;
    }

    private int numOfByte(int n){
        int m = 0b10000000;
        if((n & m) == 0) return 1;

        int count = 0;
        while(m > 0){
            if((n & m) != 0) {
                count++;
                m = m >>> 1;
            }
            else break;
        }
        if(count == 1) return -1;
        return count;
    }
    private boolean startWith10(int n){
        if((n&0b10000000) > 0 && (n&0b01000000) == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] data = {250,145,145,145,145};
        UTF8Validation test = new UTF8Validation();
        System.out.print(test.validUtf8(data));
    }
}