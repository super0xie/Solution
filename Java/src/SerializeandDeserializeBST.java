
public class SerializeandDeserializeBST {
    
    public String serialize(TreeNode root) {
        StringBuffer result = new StringBuffer();
        
        serializeHelper(root, result);
        
        return result.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
        
    }
    
    private int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strs = data.split(",");
        i = 0;
        return deserializeHelper(strs);
    }
    
    
    
    private TreeNode deserializeHelper(String[] strs) {
        String str = strs[i];
        i++;
        if("null".equals(str))  return null;
        
        
        TreeNode node = new TreeNode(Integer.parseInt(str));
        
        node.left = deserializeHelper(strs);
        node.right = deserializeHelper(strs);
        
        return node;
    }
    
}
