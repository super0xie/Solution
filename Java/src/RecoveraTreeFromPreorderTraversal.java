public class RecoveraTreeFromPreorderTraversal{

    private int idx;
    private int nextLevel;

    public TreeNode recoverFromPreorder(String S) {
        return helper(S, 0);
    }

    private TreeNode helper(String S, int level){
        
        int val = 0;
        while(idx < S.length() && S.charAt(idx) >= '0' && S.charAt(idx) <= '9') {
            val *= 10;
            val += (int)(S.charAt(idx)-'0');
            idx++;
        }

        TreeNode n = new TreeNode(val);
        if(idx >= S.length()){
            nextLevel = -1;
        }else{
            int count = 0;
            while(idx < S.length() && S.charAt(idx) == '-') {
                idx++;
                count++;
            }
            nextLevel = count;
            if(nextLevel == level+1){
                n.left = helper(S, level+1);
                if(nextLevel == level + 1){
                    n.right = helper(S, level+1);
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RecoveraTreeFromPreorderTraversal test = new RecoveraTreeFromPreorderTraversal();
        TreeNode r = test.recoverFromPreorder("1-401--349---90--88");
        System.out.println("x");
    }

}