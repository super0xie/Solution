
public class ImplementRand10UsingRand7 {
    
    private int rand7() {
        return 1;
    }
    
    public int rand10() {
        int idx;
        do {
            int col = rand7();
            int row = rand7();
            idx = (row-1) * 7 + col;
        }while(idx > 40);
        return 1 + (idx-1) % 10;  
    }
}
