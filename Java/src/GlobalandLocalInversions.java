
public class GlobalandLocalInversions {
    
    public boolean isIdealPermutation(int[] A) {
        int[] rightMin = new int[A.length];
        rightMin[A.length-1] = Integer.MAX_VALUE;
        int min = A[A.length-1];
        for(int i = A.length-2; i >= 0; i--) {
            rightMin[i] = min;
            min = Math.min(min, A[i]);
        }
        
        for(int i = 0; i < A.length-1; i++) {
            if(A[i] > rightMin[i+1]) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        GlobalandLocalInversions test = new GlobalandLocalInversions();
        int[] A = {1,0,2};
        System.out.println(test.isIdealPermutation(A));
    }
    
}
