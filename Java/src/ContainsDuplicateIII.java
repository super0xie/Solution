import java.util.TreeSet;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i <= Math.min(k, nums.length-1); i++){
            if(set.contains((long)nums[i])) return true;
            set.add((long)nums[i]);
        }

        Long pre = null;
        for(Long i : set){
            if(pre != null){
                if(Math.abs(pre-i) <= t) return true;
            }
            pre = i;
        }

        for(int i = k+1; i < nums.length; i++){
            set.remove((long)nums[i-k-1]);
            if(set.contains((long)nums[i])) return true;
            Long floor = set.floor((long)nums[i]);
            if(floor != null){
                if(Math.abs(nums[i]-floor) <= t) return true;
            }

            Long ceiling = set.ceiling((long)nums[i]);
            if(ceiling != null){
                if(Math.abs(nums[i]-ceiling) <= t) return true;
            }

            set.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        ContainsDuplicateIII test = new ContainsDuplicateIII();
        System.out.print(test.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
        
    }
}