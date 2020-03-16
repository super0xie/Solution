import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
	private List<TreeNode> result;
	private int N;
	private TreeNode root;
	
    public List<TreeNode> allPossibleFBTOld(int N) {
    	this.N = N;
        result = new ArrayList<TreeNode>();
        root = new TreeNode(0);
        
        
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if(N == 1) {
        	list.add(root);
        	return list;
        }
        list.add(root);
        helper(list, 1);

        return result;
    }
    
    private int hammingWeight(int n) {
        int result = 0;       
        for(int i = 0; i < 32; i++) {
            if(n % 2 != 0) result++;
            n = n >>> 1;
        }
        return result;
    }
    
    private void helper(List<TreeNode> list, int num) {
    	int methods = (int)Math.pow(2, list.size());
    	int nodesLeft = N-num;
    	for(int i = 1; i < methods; i++) {
    		int weight = hammingWeight(i);
    		if(weight * 2 > nodesLeft)
    			continue;
    		
    		int w = i;
    		LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
    		
    		for(TreeNode node : list) {
    			if(w % 2 == 1) {
    				node.left = new TreeNode(0);
    				node.right = new TreeNode(0);
    				nextList.add(node.left);
    				nextList.add(node.right);
    			}
    			w = w >>> 1;
    		}
    		
    		if( weight * 2 == nodesLeft ) {
    			result.add(copyTree(root));
    		}else {
    			helper(nextList, num+weight * 2);
    		}
    		
    		for(TreeNode node : list) {
    			node.left = null;
    			node.right = null;
    		}

    	}
    	
    }
    
    public TreeNode copyTree(TreeNode node) {
    	if(node == null) return null;
    	
    	TreeNode copy = new TreeNode(node.val);
    	copy.left = copyTree(node.left);
    	copy.right = copyTree(node.right);
    	
    	return copy;

	}
	

	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> res = new ArrayList<>();
		
		if(N == 1) {
			res.add(new TreeNode(0));
			return res;
		}else{
			for(int i = 1; i <= N-2; i += 2){
				List<TreeNode> left = allPossibleFBT(i);
				List<TreeNode> right = allPossibleFBT(N-1-i);

				for(int j = 0; j < left.size(); j++){
					for(int k = 0; k < right.size(); k++){
						TreeNode r = new TreeNode(0);
						r.left = left.get(j);
						r.right =right.get(k);
						res.add(r);
					}
				}
			}
			return res;
		}
    }
    
    public static void main(String[] args) {
    	AllPossibleFullBinaryTrees test = new AllPossibleFullBinaryTrees();
    	List<TreeNode> result = test.allPossibleFBT(5);
    	
//    	TreeNode n1 = new TreeNode(1);
//    	TreeNode n2 = new TreeNode(2);
//    	TreeNode n3 = new TreeNode(3);
//    	TreeNode n4 = new TreeNode(4);
//    	TreeNode n5 = new TreeNode(5);
//    	
//    	n1.left = n2;
//    	n1.right = n3;
//    	n3.left = n4;
//    	n3.right = n5;
//    	
//    	TreeNode copy = test.copyTree(n1);
    	
    	System.out.println(result.size());
    	
    }
    
}
