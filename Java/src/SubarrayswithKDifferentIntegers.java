import java.util.HashMap;

public class SubarrayswithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        int l = 0;
        int r = -1;
        int res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < A.length){
            if(map.size() < K){
                r++;
                if(r < A.length){
                    map.put(A[r], map.getOrDefault(A[r], 0) + 1);
                }
            }else if(map.size() == K){
                int i = r;
                while(i < A.length && map.containsKey(A[i])){
                    i++;
                }
                res += i-r;

                if(map.get(A[l]) == 1) map.remove(A[l]);
                else map.put(A[l], map.get(A[l])-1);
                l++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,1,3,4};
        SubarrayswithKDifferentIntegers test = new SubarrayswithKDifferentIntegers();
        System.out.println(test.subarraysWithKDistinct(A, 3));
    }

}