
public class CountingBits {
    
    public int[] countBits(int num) {
        if(num == 0) {
            int [] result = {0};
            return result;
        }
        
        int [] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        
        int window = 2;
        for(int i = 2; i < num+1; i++) {
            if(i == 2 * window) window = i;
            result[i] = 1 + result[i-window];
        }
        
        return result;

    }
    
    public static void main(String[] strs) {
        CountingBits cb = new CountingBits();
        int[] result = cb.countBits(5);
        
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

}
