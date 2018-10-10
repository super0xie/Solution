import java.util.HashMap;
import java.util.List;

public class BrickWall {
    
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> l : wall) {
            int sum = 0;
            
            for(int i = 0; i < l.size()-1; i++) {
                sum += l.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        
        if(max == Integer.MIN_VALUE) return wall.size();
        return wall.size() - max;
    }
}
