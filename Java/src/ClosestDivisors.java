
public class ClosestDivisors {
    
    public int[] closestDivisors(int num) {
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = num+1 ; i <= num+2; i++) {
            int n = (int) Math.sqrt(i);
            for(int j = n; j >= 1; j--){
                if(i % j == 0) {
                    int other = i / j;
                    if(other - j < minDiff) {
                        minDiff = other - j;
                        res[0] = j;
                        res[1] = other;
                    }
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ClosestDivisors test = new ClosestDivisors();
        int[] res = test.closestDivisors(999);
        System.out.println(res[0] + ", " + res[1]);
    }
    
}
