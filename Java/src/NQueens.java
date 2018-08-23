import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    
//    List<Integer> resultX;
//    List<Integer> resultY;
    
    int n = 0;
    int[] cols;
    
    boolean[] colTaken;
    boolean[] rdTaken;
    boolean[] ldTaken;
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;  
        colTaken = new boolean [n];
        rdTaken = new boolean [n * 2 - 1];
        ldTaken = new boolean [n * 2 - 1];
        result = new ArrayList<List<String>>();
        cols = new int [n];

        dfs(0);
        
        return result;
    }
    
    private void dfs(int i) {
        
        for(int j = 0; j < n; j++) {
            int rdIndex = i+j;
            int ldIndex = i - j + n - 1;
            if(!colTaken[j] && !rdTaken[rdIndex] && !ldTaken[ldIndex]) {
                //OMG!! We found a solution!
                cols[i] = j;
                if(i == n-1) {
                    List<String> solution = new ArrayList<String>();
                    for(int k = 0; k < n; k++) {
                        int qIndex = cols[k];
                        char[] chars = new char[n];
                        Arrays.fill(chars, '.');
                        chars[qIndex] = 'Q';
                        String str = String.copyValueOf(chars);
                        solution.add(str);
                    }
                    result.add(solution);
                }else {
                    colTaken[j] = true;
                    rdTaken[rdIndex] = true;
                    ldTaken[ldIndex] = true;
                    dfs(i+1);
                    colTaken[j] = false;
                    rdTaken[rdIndex] = false;
                    ldTaken[ldIndex] = false;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        NQueens test = new NQueens();
        List<List<String>> result = test.solveNQueens(5);
        
        System.out.println("hello");
    }
    
    
    

}
