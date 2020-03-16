import java.util.Arrays;
import java.util.HashMap;

public class MaxChunksToMakeSortedII{

    public int maxChunksToSortedOld(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sorted.length; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], i);
            }
        }

        int res = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            int idx = map.get(arr[i]);
            if(idx > end){
                end = idx;
            }

            if(i == end){
                res++;
                end = i+1;
            }
            map.put(arr[i], idx+1);
        }

        return res;
    }

    class Num implements Comparable<Num>{
        int n;
        int idx;

        Num(int i){
            n = i;
        }

        @Override
        public int compareTo(Num o) {
            return n-o.n;
        }
        
    }

    public int maxChunksToSorted(int[] arr) {

        Num[] ori = new Num[arr.length];
        Num[] sorted = new Num[arr.length];
        for(int i = 0; i < arr.length; i++){
            Num num = new Num(arr[i]);
            ori[i] = num;
            sorted[i] = num;
        }
        Arrays.sort(sorted);

        for(int i = 0; i < arr.length; i++){
            sorted[i].idx = i;
        }

        int res = 0;
        int end = 0;
        for(int i = 0; i < ori.length; i++){
            int idx = ori[i].idx;
            if(idx > end){
                end = idx;
            }

            if(i == end){
                res++;
                end = i+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII test = new MaxChunksToMakeSortedII();
        int[] arr = {2,1,3,4,4};
        System.out.println(test.maxChunksToSorted(arr));
    }

}