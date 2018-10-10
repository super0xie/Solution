
public class ValidPerfectSquare {
    
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        
        for(int i = 0; i <= num; i++) {
            int sq = i * i;
            if(sq == num) return true;
            if(sq < 0 || sq > num) return false;
        }
        
        return false;
        
    }
    
    public static void main(String[] ags) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(2147483647));
    }
    
}
