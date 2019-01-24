import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int tar = A.length;
        for(int i = A.length-1; i > 0; i--) {
            for(int j = 0; j <= i; j++) {
                if(A[j] == tar) {
                    res.add(j+1);
                    flip(A, j);
                    break;
                }
            }
            
            res.add(i+1);
            flip(A, i);
            
            tar--;
        }
        return res;
    }
    
    private void flip(int[] A, int r) {
        int i = 0;
        int j = r;
        
        while(i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }
    
    public static void main(String[] args) {
        PancakeSorting test = new PancakeSorting();
        int[] A = {3,2,4,1};
        List<Integer> res = test.pancakeSort(A);
        System.out.println("hel");
    }
}
