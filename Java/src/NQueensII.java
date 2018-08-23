import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
	int n = 0;
    boolean[] colTaken;
    boolean[] rdTaken;
    boolean[] ldTaken;
    int result = 0;
    
    public int totalNQueens(int n) {
        this.n = n;  
        colTaken = new boolean [n];
        rdTaken = new boolean [n * 2 - 1];
        ldTaken = new boolean [n * 2 - 1];
        result = 0;
        dfs(0);
        return result;
    }
    
    private void dfs(int i) {
        
        for(int j = 0; j < n; j++) {
            int rdIndex = i+j;
            int ldIndex = i - j + n - 1;
            if(!colTaken[j] && !rdTaken[rdIndex] && !ldTaken[ldIndex]) {
                //OMG!! We found a solution!
                if(i == n-1) {
                    result++;
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

}
