import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class PatchingArray {

    public int minPatchesOld(int[] nums, int n) {

        TreeSet<Long> set = new TreeSet<>();
        for(long i : nums){
            ArrayList<Long> l = new ArrayList<>();
            for(long j : set){
                l.add(j + i);
            }
            set.add(i);
            set.addAll(l);
        }

        long cur = 1;
        int res = 0;

        while(cur <= n){
            if(set.contains(cur)) {
                cur++;
                continue;
            }

            res++;
            long oldEnd = cur;
            long newEnd = cur * 2 - 1;
            long floor = set.floor(newEnd+1) == null ? Long.MIN_VALUE : set.floor(newEnd+1);
            while(floor > oldEnd) {
                while(set.contains(floor+1)) floor++;
                oldEnd = floor;
                newEnd = floor + (cur * 2 - 1);
                floor = set.floor(newEnd+1);
            }
            cur = newEnd+1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 32};
        PatchingArray test = new PatchingArray();
        System.out.println(test.minPatchesOld(nums, 2147483647));
    }

}