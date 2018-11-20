import java.util.HashSet;

public class FairCandySwap {
    
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        
        for(int i : A) {
            sumA += i;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : B) {
            sumB += i;
            set.add(i);
        }
        
        int aux = (sumB - sumA) / 2;
        for(int i : A) {
            if(set.contains(i + aux)) return new int[] {i, i+aux}; 
        }
        
        return null;
    }
    
}
