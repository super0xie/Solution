import java.util.HashSet;
import java.util.Random;

public class RandomFlipMatrix {


    private int m;
    private int n;
    private HashSet<Integer> set;
    private Random r;
    private int count = 0;

    public void Solution(int n_rows, int n_cols) {
        m = n_rows;
        n = n_cols;
        set = new HashSet<>();
        r = new Random();
    }
    
    public int[] flip() {
        while(true){
            int i = r.nextInt(m);
            int j = r.nextInt(n);
            count++;
            if(!set.contains(i * 10001 + j)){
                set.add(i * 10001 + j);
                return new int[] {i, j};
            }
        }
    }
    
    public void reset() {
        set.clear();
    }

    public static void main(String[] args) {
        int i = 0;
        // RandomFlipMatrix test = new RandomFlipMatrix();
        // test.Solution(100, 100);
        
        // while(i < 100 * 100){
        //     test.flip();
        //     i++;
        // }

        // System.out.println(test.count);


        double n = 1000000;
        double sum = 0;
        for(i = 1; i <= n ; i++){
            sum += n / i;
        }
        System.out.println(sum);
    }

}


