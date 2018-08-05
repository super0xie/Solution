import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> currentList = new ArrayList<Integer>();
		
		pathSumHelper(root, sum, 0, result, currentList);
        
        return result;
    }
	
	private void pathSumHelper(TreeNode root, int sum, int currentSum, 
			ArrayList<List<Integer>> result, ArrayList<Integer> currentList){
		if(root == null) return;
		
		currentSum += root.val;
		if(root.left == null && root.right == null && currentSum == sum) {
			ArrayList<Integer> copy = new ArrayList<Integer>(currentList);
			copy.add(root.val);
			result.add(copy);
			return;
		}
		
		currentList.add(root.val);
		pathSumHelper(root.left, sum, currentSum, result, currentList);
		pathSumHelper(root.right, sum, currentSum, result, currentList);
		currentList.remove(currentList.size() - 1);
		
	}
    
    

}
