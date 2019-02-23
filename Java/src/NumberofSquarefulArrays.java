
import java.util.Arrays;

public class NumberofSquarefulArrays{

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        boolean[] used = new boolean[A.length];
        return dfs(A, used, -1, 0);
    }

    private int dfs(int[] A, boolean[] used, int last, int step){
        if(step == A.length) {
            return 1;
        }
        int res = 0;
        for(int i = 0; i < A.length; i++){
            if(used[i]) continue;
            boolean valid = false;
            if(step == 0) valid = true;
            else{
                valid = isPerfectSquare(last+A[i]);
            }

            if(valid){
                used[i] = true;
                res += dfs(A, used, A[i], step+1);
                used[i] = false;
                int j = i+1;
                while(j < A.length && A[j] == A[i]) j++;
                i = j-1;
            }
        }
        return res;
    }


    private boolean isPerfectSquare(int i){
        double sqrt = Math.sqrt(i);
        if(sqrt == Math.ceil(sqrt)) return true;
        return false;
    }

    public static void main(String[] args) {
        NumberofSquarefulArrays test = new NumberofSquarefulArrays();
        int[] A = {0,0,0,1,1,1};
        System.out.print(test.numSquarefulPerms(A));
    }



}