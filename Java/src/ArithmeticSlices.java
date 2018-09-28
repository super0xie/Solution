
public class ArithmeticSlices {
    
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length <= 2) return 0;
        int[] diff = new int [A.length-1];
        for(int i = 1; i < A.length; i++) {
            diff[i-1] = A[i] - A[i-1];
        }
        
        int res = 0;
        for(int i = 0; i < diff.length-1; i++) {
            if(diff[i] == diff[i+1]) {
                int start = i;
                int end = i;
                while(end < diff.length-1 && diff[end] == diff[end+1]) end++;
                
                int count = end - start;
                res += count * (count+1) / 2;
                i = end;
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ArithmeticSlices test = new ArithmeticSlices();
        int[] A = {1,2,3,4};
        System.out.println(test.numberOfArithmeticSlices(A));
    }
    
}
