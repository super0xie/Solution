
public class SmallestStringStartingFromLeaf {
	
	private String min = "zzzzzzz";
	public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return min;
    }
	
	private void helper(TreeNode n, StringBuilder sb) {
		if(n == null) return;
		sb.append((char)('a' + n.val));
		if(n.left == null && n.right == null) {
			StringBuilder aux = new StringBuilder(sb);
			String str = aux.reverse().toString();
			
			if(str.compareTo(min) < 0) min = str;
		}else {
			helper(n.left, sb);
			helper(n.right, sb);
		}
		sb.deleteCharAt(sb.length()-1);
	}
	
}
