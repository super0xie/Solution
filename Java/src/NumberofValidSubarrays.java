import java.util.Arrays;
import java.util.TreeSet;

public class NumberofValidSubarrays{
    //n2
    public int validSubarraysOld(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i+1;
            for(; j < nums.length; j++){
                if(nums[j] < nums[i]) break;
            }
            res += j-i;
        }

        return res;
    }
    
    //nlogn
    public int validSubarrays(int[] nums) {
        Integer[] indice = new Integer[nums.length];
        for(int i = 0; i < indice.length; i++) indice[i] = i;
        Arrays.sort(indice, (a, b) -> {
            return nums[a]-nums[b];
        });

        int res = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < indice.length; i++){
            Integer ret = set.ceiling(indice[i]);
            if(ret == null) ret = nums.length;
            res += ret - indice[i];

            set.add(indice[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        NumberofValidSubarrays test = new NumberofValidSubarrays();
        int[] nums = {3,2,1};
        System.out.println(test.validSubarrays(nums));
    }

}