import java.util.HashSet;

public class FirstMissingPositive{

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        for(int i = 1; i <= nums.length+1; i++){
            if(!set.contains(i)) return i;
        }

        return -1;
    }

}