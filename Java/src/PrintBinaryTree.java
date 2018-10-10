import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    
    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        int w = getWidth(h);
        String[][] aux = new String[h][w];
        helper(root, 0, 0, w-1, aux);
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i = 0; i < h; i++) {
            List<String> l = new ArrayList<String>();
            for(int j = 0; j < w; j++) {
                if(aux[i][j] == null) {
                    l.add("");
                }else {
                    l.add(aux[i][j]);
                }
            }
            res.add(l);
        }
        return res;
    }
    
    private void helper(TreeNode n, int row, int l, int r, String[][] aux) {
        if(n == null) return;
        int idx = l + (r - l) / 2;
        
        aux[row][idx] = String.valueOf(n.val);
        helper(n.left, row+1, l, idx-1, aux);
        helper(n.right, row+1, idx+1, r, aux);
        
    }
    
    private int getHeight(TreeNode n) {
        if(n == null) return 0;
        else return 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }
    
    private int getWidth(int h) {
        if(h == 1) return 1;
        else return getWidth(h-1) * 2 + 1;
    }
    
}
