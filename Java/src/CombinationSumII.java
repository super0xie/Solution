import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	List<List<Integer>> result;
	int target;
	int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	this.target = target;
    	this.candidates = candidates;
        result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<Integer>();
        dfs(0, list, 0);
        return result;
    }
    
    private void dfs(int startIndex, List<Integer> list, int sum) {
    	if(startIndex >= candidates.length) return;
    	
    	for(int i = startIndex; i < candidates.length;) {
    		if(candidates[i] + sum < target) {
    			list.add(candidates[i]);
    			dfs(i+1, list, sum+candidates[i]);
    			list.remove(list.size()-1);
    		}else if(candidates[i] + sum == target) {
    			List<Integer> solution = new ArrayList<Integer>(list);
    			solution.add(candidates[i]);
    			result.add(solution);
    		}else {
    			return;
    		}
    		
    		while(i < candidates.length-1 && candidates[i] == candidates[i+1]) {
    			i++;
    		}
    		i++;
    	}
    }
    
    public static void main(String[] args) {
    	int[] candidates = {2,5,2,1,2};
    	CombinationSumII test = new CombinationSumII();
    	test.combinationSum2(candidates, 5);
    	
    	System.out.println("hello");
    }
}
