
public class CreateBinaryTree {
    
    private static int i;

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String [] strs = data.split(",");
        i = 0;
        return deserializeHelper(strs);
    }
    
    
    
    private static TreeNode deserializeHelper(String[] strs) {
        if(i >= strs.length) return null;
        String str = strs[i];
        i++;
        if("null".equals(str))  return null;
        
        
        TreeNode node = new TreeNode(Integer.parseInt(str));
        
        node.left = deserializeHelper(strs);
        node.right = deserializeHelper(strs);
        
        return node;
    }
    
    
}
