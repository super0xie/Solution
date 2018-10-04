
public class SerializeAndDeserializeBinaryTree {
    
    
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
    
    
    
    
    
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        dfs(sb, root);
        
        return sb.toString();
    }
    
    private void dfs (StringBuilder sb, TreeNode n) {
        if(n == null) sb.append("null,");
        else {
            sb.append(n.val + ",");
            dfs(sb, n.left);
            dfs(sb, n.right);
        }
    }
    
    private int idx;
    public TreeNode deserialize2(String str) {
        String[] strs = str.split(",");
        return deserialize2Helper(strs);
    }
    
    private TreeNode deserialize2Helper(String[] strs) {
        
        String str = strs[idx++];
        if(str.equals("null")) {
            return null;
        }else {
            TreeNode n = new TreeNode(Integer.parseInt(str));
            n.left = deserialize2Helper(strs);
            n.right = deserialize2Helper(strs);
            return n;
        }
        
    }
    
    
    
    
    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
//        
        SerializeAndDeserializeBinaryTree test = new SerializeAndDeserializeBinaryTree();
//        
//        System.out.println(test.serialize(n1));
        TreeNode root = test.deserialize2("1,2,null,null,3,4,null,null,5,null,null,");
        
        
        System.out.println(test.serialize2(root));
    }

}
