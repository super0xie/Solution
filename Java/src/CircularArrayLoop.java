import java.util.ArrayList;
import java.util.List;

public class CircularArrayLoop {
    
    public boolean circularArrayLoop(int[] nums) {
        
        boolean[] outerVisited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(outerVisited[i]) continue;
            boolean [] visited = new boolean [nums.length];
            List<Integer> list = new ArrayList<Integer>();
            visited[i] = true;
            list.add(i);
            
            int cur = i;
            
            int next = next(nums, cur);
            while(next != cur && nums[i] * nums[next] > 0) {
                if(visited[next]) return true;
                visited[next] = true;
                cur = next;
                list.add(cur);
                next = next(nums, cur);
                if(outerVisited[next]) break;
            }
            
            for(int j : list)
                outerVisited[j] = true;
        }
        return false;
        
    }
    
    private int next(int[] nums, int idx) {
        int res = idx + nums[idx];
        if(res >= nums.length) res = res % nums.length;
        if(res < 0) res = nums.length - (-res) % nums.length;
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};
        CircularArrayLoop test = new CircularArrayLoop();
        System.out.println(test.circularArrayLoop(nums));

    }

}
