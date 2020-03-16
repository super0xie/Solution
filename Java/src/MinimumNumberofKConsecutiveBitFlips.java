import java.util.LinkedList;

public class MinimumNumberofKConsecutiveBitFlips {

    public int minKBitFlipsOld(int[] A, int K) {
        int count = 0;
        int i = 0;
        for(; i <= A.length-K; i++){
            if(A[i] == 0){
                count++;
                for(int j = i; j < i+K; j++){
                    A[j] = A[j] ^ 1;
                }
            }
        }

        for(; i < A.length; i++){
            if(A[i] == 0) return -1;
        }

        return count;
    }

    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        int i = 0;
        LinkedList<Integer> l = new LinkedList<>();
        for(; i <= A.length-K; i++){
            if(!l.isEmpty() && i-l.getFirst() >= K) l.poll();
            if(l.size() % 2 != 0) A[i] = A[i] ^ 1;
            if(A[i] == 0){
                count++;
                for(int j = i; j < i+K; j++){
                    A[j] = A[j] ^ 1;
                }
            }
        }

        for(; i < A.length; i++){
            if(!l.isEmpty() && i-l.getFirst() >= K) l.poll();
            if(l.size() % 2 != 0) A[i] = A[i] ^ 1;
            if(A[i] == 0) return -1;
        }

        return count;
    }
}