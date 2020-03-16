import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomPickwithBlacklist {

    private Random r;
    private HashSet<Integer> b;
    private int N;
    private boolean pick;
    private ArrayList<Integer> picklist;

    public void Solution(int N, int[] blacklist) {
        r = new Random();
        this.N = N;
        b = new HashSet<>();
        for(int i : blacklist) {
            if(i < N)
                b.add(i);
        }

        if(blacklist.length * 2 >= N){
            pick = true;
            picklist = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(!b.contains(i)) picklist.add(i);
            }
        }
    }
    
    public int pick() {
        if(pick){
            int idx = r.nextInt(picklist.size());
            return picklist.get(idx);
        }else{
            boolean found = false;
            int n = 0;
            while(!found){
                n = r.nextInt(N);
                if(!b.contains(n))
                    found = true;
            }
            return n;
        }
    }

    public static void main(String[] args) {
        RandomPickwithBlacklist test = new RandomPickwithBlacklist();
        test.Solution(5, new int[] {1,2,3});
        for(int i = 0; i < 10; i++)
            System.out.println(test.pick());
    }



}