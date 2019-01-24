
public class PowerofFour {
    
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        if(num % 4 != 0) return false;
        return isPowerOfFour(num / 4);
    }
    
    public static void main(String[] args) {
        System.out.println(-1 % 4);
    }
}