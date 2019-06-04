import java.util.Arrays;
import java.util.HashMap;

public class DistantBarcodes {

    public int[] rearrangeBarcodesOld(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : barcodes){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] res = new int[barcodes.length];
        Integer[] cp = new Integer[barcodes.length];
        for(int i = 0; i < barcodes.length; i++) cp[i] = barcodes[i];
        Arrays.sort(cp, (a, b)->{
            int counta = map.get(a);
            int countb = map.get(b);
            if(counta != countb) return countb-counta;
            else return a-b;
        });

        int idx = 0;
        for(int i = 0; i < barcodes.length; i++){
            res[idx] = cp[i];
            idx += 2;
            if(idx >= barcodes.length) idx = 1;
        }

        return res;
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] count = new int[10001];
        for(int i : barcodes){
            count[i]++;
        }

        int[] res = new int[barcodes.length];
        Integer[] cp = new Integer[barcodes.length];
        for(int i = 0; i < barcodes.length; i++) cp[i] = barcodes[i];
        Arrays.sort(cp, (a, b)->{
            if(count[a] != count[b]) return count[b]-count[a];
            else return a-b;
        });

        int idx = 0;
        for(int i = 0; i < barcodes.length; i++){
            res[idx] = cp[i];
            idx += 2;
            if(idx >= barcodes.length) idx = 1;
        }

        return res;
    }

    public static void main(String[] args) {
        DistantBarcodes test = new DistantBarcodes();
        int[] barcodes = {1,1,1,1,2,2,3,3};
        int[] res = test.rearrangeBarcodes(barcodes);
        for(int i : res) System.out.print(i + ", ");
    }

}