
public class EliminationGame {
    
    public int lastRemaining(int n) {
        return helper(n, true);
    }
    
    public int helper(int n, boolean l) {
        if(n == 1) return 1;
        int r = helper(n/2, !l);
        if(n % 2 == 0) {
            if(l) return 2*r;
            else return 2*r-1;
        }else {
            return 2*r;
        }
    }
    
    public static void main(String[] args) {
        EliminationGame test = new EliminationGame();
        System.out.println(test.lastRemaining(9));
    }
    
}
