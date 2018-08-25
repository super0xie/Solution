
public class Numberof1Bits {
    
    public int hammingWeight(int n) {
        int result = 0;
        
        for(int i = 0; i < 32; i++) {
            if(n % 2 != 0) result++;
            n = n >>> 1;
            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE + 1;
        System.out.println(a);
        System.out.println(a%2);
        System.out.println(Integer.toBinaryString(a>>>30));
    }
}
