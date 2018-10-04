import java.util.HashSet;

public class MatchstickstoSquare {
    
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 4 != 0) return false;
        int side = sum / 4;
        
        
        for(int i : nums) {
            if(i > side) return false;
        }
        
        boolean [] used = new boolean [nums.length];
        HashSet<Integer> visited = new HashSet<Integer>();
        
        
        return dfs(nums, 0, used, 0, side, visited);
        
    }
    
    private boolean dfs(int[] nums, int sum, boolean [] used, int count, int side, HashSet<Integer> visited) {
        int encode = encode(used);
        if(visited.contains(encode)) {
            return false;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                int aux = sum + nums[i];
                if(aux == side) {
                    if(count == 3) return true;
                    used[i] = true;
                    boolean res = dfs(nums, 0, used, count+1, side, visited);
                    used[i] = false;
                    if(res) return true;
                }else if(aux < side){
                    used[i] = true;
                    boolean res = dfs(nums, aux, used, count, side, visited);
                    used[i] = false;
                    if(res) return true;
                }
            }
        }
        
        visited.add(encode);
        return false;
    }
    
    private int encode(boolean[] used) {
        int res = 0;
        for(boolean i : used) {
            res = res << 1;
            if(i) res += 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        MatchstickstoSquare test = new MatchstickstoSquare();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(test.makesquare(nums));
        
//        boolean [] used = new boolean [10];
//        used[7] = true;
//        used[9] = true;
//        System.out.println(test.encode(used));
    }
    
}
