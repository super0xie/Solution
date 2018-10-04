import java.util.Arrays;

public class WiggleSortII {
    
    public void wiggleSort(int[] nums) {
        int[] aux = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            aux[i] = nums[i];
        }
        
        Arrays.sort(aux);
        
        int l = (nums.length - 1) / 2;
        int r = aux.length-1;
        
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = aux[l--];
            }else {
                nums[i] = aux[r--];
            }
        }
    }
    
}
