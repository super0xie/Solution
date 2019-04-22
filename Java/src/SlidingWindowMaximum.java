import java.util.TreeMap;

public class SlidingWindowMaximum{

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[]{};
        int[] res = new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int idx = 0;
        res[idx++] = map.lastKey();
        for(int i = k; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i-k]) == 1){
                map.remove(nums[i-k]);
            }else{
                map.put(nums[i-k], map.get(nums[i-k])-1);
            }
            res[idx++] = map.lastKey();
        }

        return res;
    }

}