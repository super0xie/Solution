import java.util.HashMap;
import java.util.TreeMap;

public class CountofRangeSum {

    public int countRangeSumLong(int[] nums, int lower, int upper) {
        HashMap<Long, Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            HashMap<Long, Integer> aux = new HashMap<>();
            for(long j : map.keySet()){
                long sum = nums[i] + j;
                if(sum >= lower && sum <= upper) res += map.get(j);
                aux.put(sum, map.get(j));
            }

            if(nums[i] >= lower && nums[i] <= upper) res++;
            aux.put((long)nums[i], aux.getOrDefault((long)nums[i], 0) + 1);
            map = aux;
        }

        return res;
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long offset = 0;
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            offset += nums[i];
            long key = (long)nums[i]-offset;
            map.put(key, map.getOrDefault(key, 0) + 1);

            for(long j : map.subMap(lower-offset, true, upper-offset, true).keySet()){
                res += map.get(j);
            }
        }

        return res;
    }
    
    
    public int countRangeSumTLE(int[] nums, int lower, int upper) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> aux = new HashMap<>();
            for(Integer j : map.keySet()){
                Integer sum = nums[i] + j;
                if(sum >= lower && sum <= upper) res += map.get(j);
                aux.put(sum, map.get(j));
            }

            if(nums[i] >= lower && nums[i] <= upper) res++;
            aux.put(nums[i], aux.getOrDefault(nums[i], 0) + 1);
            map = aux;
        }

        return res;
    }
    

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        CountofRangeSum test = new CountofRangeSum();
        System.out.println(test.countRangeSumLong(nums, -2, 2));
    }

}