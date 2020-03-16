
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
	
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null) return null;
        
        if(cloned.val == target.val) return cloned;
        TreeNode l = getTargetCopy(original, cloned.left, target);
        TreeNode r = getTargetCopy(original, cloned.right, target);
        
        if(l != null) return l;
        if(r != null) return r;
        return null;
    }
	
}
