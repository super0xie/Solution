import java.util.HashMap;

public class CombinationSumIV {
    
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dfs(nums, target, cache);
    }
    
    private int dfs(int[] nums, int target, HashMap<Integer, Integer> cache) {
        if(target == 0) return 1;
        if(cache.containsKey(target)) return cache.get(target);
        
        int res = 0;
        for(int i : nums) {
            if(i <= target)
                res += dfs(nums, target-i, cache);
        }
        
        cache.put(target, res);
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        CombinationSumIV test = new CombinationSumIV();
        System.out.println(test.combinationSum4(nums, 4));
    }
}
