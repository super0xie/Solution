import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
	private HashMap<Integer, List<Integer>> map;
	public void Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i < nums.length; i++) {
        	List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
        	list.add(i);
        	map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        Random r = new Random();
        List<Integer> list = map.get(target);
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
    
    public static void main(String[] args) {
    	System.out.println();
    }
}
