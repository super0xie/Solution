
public class PowerofThree {
    
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        if(n % 3 == 0) return isPowerOfThree(n/3);
        else return false;
    }
    
    public static void main(String[] args) {
        PowerofThree test = new PowerofThree();
        System.out.println(test.isPowerOfThree(27)); 
    }
    
}
