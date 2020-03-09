import java.util.Arrays;

public class SortIntegersbyTheNumberof1Bits {
    
    class Num implements Comparable<Num>{
        int n;
        int c;
        
        Num(int n){
            this.n = n;
            c = 0;
            while(n > 0) {
                if(n % 2 == 1) c++;
                n = n / 2;
            }
        }

        @Override
        public int compareTo(Num o) {
            if(this.c != o.c) {
                return this.c - o.c;
            }else {
                return this.n - o.n;
            }
        }
    }
    
    public int[] sortByBits(int[] arr) {
        Num[] aux = new Num[arr.length];
        for(int i = 0; i < arr.length; i++) {
            aux[i] = new Num(arr[i]);
        }
        Arrays.sort(aux);
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            res[i] = aux[i].n;
        }
        return res;
    }
    
}
