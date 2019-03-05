import java.util.LinkedList;

public class MaxConsecutiveOnesIII{

    public int longestOnesDirty(int[] A, int K) {
        LinkedList<Integer> indice = new LinkedList<>();

        int lastZero = -1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 1){
                res = Math.max(res, i-lastZero);
            }else{
                if(indice.size() < K){
                    indice.addLast(i);
                }else{
                    indice.addLast(i);
                    lastZero = indice.removeFirst();
                }
                res = Math.max(res, i-lastZero);
            }
            
        }
        return res;
    }

    public int longestOnes(int[] A, int K) {
        LinkedList<Integer> indice = new LinkedList<>();
        int lastZero = -1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0) {
                indice.addLast(i);
                if(indice.size() > K) lastZero = indice.removeFirst();
            }
            res = Math.max(res, i-lastZero);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        MaxConsecutiveOnesIII test = new  MaxConsecutiveOnesIII();
        System.out.print(test.longestOnes(A, 2));
    }

}

