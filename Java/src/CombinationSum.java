import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result;
	int[] candidates;
	int target;
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        this.candidates = candidates;
        this.target = target;
        
        List<Integer> list = new ArrayList<Integer>();
        
        dfs(list, 0, 0);
        
        return result;
    }
    
    private void dfs(List<Integer> list, int sum, int startIndex) {
    	for(int i = startIndex; i < candidates.length; i++) {
    		if(sum + candidates[i] == target) {
    			List<Integer> newList = new ArrayList<Integer>(list);
    			newList.add(candidates[i]);
    			result.add(newList);
    		}else if(sum + candidates[i] < target) {
    			list.add(candidates[i]);
    			dfs(list, sum+candidates[i], i);
    			list.remove(list.size()-1);
    		}
    	}
    }

}
