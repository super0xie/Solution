import java.util.HashSet;

public class FrogJump {
    
    private HashSet<String> map = new HashSet<String>();
    private int[] stones;
    
    public boolean canCross(int[] stones) {
        this.stones = stones;
        return dfs(0, 0);
    }
    
    private boolean dfs(int index, int step) {
        String key = step + "+" + index;
        if(map.contains(key)) return false;
        
        for(int i = index+1; i < stones.length; i++) {
            int diff = stones[i] - stones[index];
            if((diff == step-1 || diff == step || diff == step+1) && (diff > 0)) {
                if(i == stones.length-1) return true;
                if(dfs(i, diff)) return true;
            }else if(diff > step + 1) {
                break;
            }
        }
        
        map.add(key);
        return false;
    }
    
    public static void main(String[] args) {
        
        FrogJump test = new FrogJump();
        int[] stones = {0,1,3,4,5,7,9,10,12};
        System.out.println(test.canCross(stones));
    }
    
}
