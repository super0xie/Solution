import java.util.TreeMap;

public class SmallestRotationwithHighestScore {

    public int bestRotationTLE(int[] A) {
        int res = 0;
        int maxScore = 0;

        for(int i = 0; i < A.length; i++){
            int s = 0;
            for(int j = 0; j < A.length; j++){
                int idx = i + j;
                if(idx >= A.length) idx -= A.length;
                if(A[idx] <= j) s++;
            }
            if(s > maxScore) {
                res = i;
                maxScore = s;
            }
        }

        return res;
    }

    public int bestRotationTLE2(int[] A) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int[] aux = new int[A.length];
        for(int i = 0; i < A.length; i++){
            aux[i] = A[i] - i;
            right.put(aux[i], right.getOrDefault(aux[i], 0)+1);
        }

        int tl = A.length;
        int tr = 0;
        int res = 0;
        int maxScore = 0;
        for(int i = 0; i < A.length; i++){
            int s = 0;

            for(int v : left.headMap(tl, true).values()){
                s += v;
            }

            for(int v : right.headMap(tr, true).values()){
                s += v;
            }

            left.put(aux[i], left.getOrDefault(aux[i], 0)+1);
            right.put(aux[i], right.get(aux[i])-1);

            if(right.get(aux[i]) == 0){
                right.remove(aux[i]);
            }

            if(s > maxScore) {
                res = i;
                maxScore = s;
            }

            tl--;
            tr--;
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestRotationwithHighestScore test = new SmallestRotationwithHighestScore();
        int[] A = {2,3,1,4,0};
//        System.out.println(test.bestRotation(A));
    }

}