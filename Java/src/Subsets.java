import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, 0, list);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> list) {
    	if(index == nums.length-1) {
    		res.add(new ArrayList<Integer>(list));
    		list.add(nums[index]);
    		res.add(new ArrayList<Integer>(list));
    		list.remove(list.size()-1);
    	}else {
    		dfs(nums, index+1, list);
    		list.add(nums[index]);
        	dfs(nums, index+1, list);
        	list.remove(list.size()-1);
    	}
    }
}
