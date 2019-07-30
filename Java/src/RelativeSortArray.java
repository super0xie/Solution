import java.util.Arrays;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] aux = new int[1001];
        int max = Integer.MAX_VALUE / 2;
        for(int i = 0; i < aux.length; i++) aux[i] = max + i;
        for(int i = 0; i < arr2.length; i++){
            aux[arr2[i]] = i+1;
        }

        Integer[] arr = new Integer[arr1.length];
        for(int i = 0; i < arr1.length; i++) arr[i] = arr1[i];
        Arrays.sort(arr, (a, b)->{
            return aux[a] - aux[b];
        });

        int[] res = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) res[i] = arr[i];
        return res;
    }

}