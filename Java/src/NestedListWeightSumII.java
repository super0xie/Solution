import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII {
	
	private List<Integer> val = new ArrayList<Integer>();
	private List<Integer> depths = new ArrayList<Integer>();
	int maxDepth = Integer.MIN_VALUE;
	public int depthSumInverse(List<NestedInteger> nestedList) {
		helper(nestedList, 1);
		int sum = 0;
		for(int i = 0; i < val.size(); i++) {
			sum += val.get(i) * (maxDepth-depths.get(i)+1);
		}
		return sum;
        
    }
	
	private void helper(List<NestedInteger> nestedList, int depth) {
		maxDepth = Math.max(maxDepth, depth);
		for(NestedInteger ni : nestedList) {
			if(ni.isInteger()) {
				val.add(ni.getInteger());
				depths.add(depth);
			}else {
				helper(ni.getList(), depth+1);
			}
		}
	}

}
