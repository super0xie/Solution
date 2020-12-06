import java.util.Arrays;

public class KthAncestorofaTreeNode {
//	TLE
//	private int[] p;
//	public void TreeAncestor(int n, int[] parent) {
//        p = parent;
//    }
//    
//    public int getKthAncestor(int node, int k) {
//        int n = node;
//        for(int i = 0; i < k; i++) {
//        	n = p[n];
//        	if(n == -1) break;
//        }
//        return n;
//    }
	
//	MLE
//	private int[][] dp;
//	public void TreeAncestor(int n, int[] parent) {
//        dp = new int[n][n+1];
//        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
//        
//        for(int i = 0; i < n; i++) {
//        	int cur = i;
//        	int k = 0;
//        	while(cur != -1) {
//        		dp[i][k++] = cur;
//        		cur = parent[cur];
//        	}
//        }
//    }
//    
//    public int getKthAncestor(int node, int k) {
//        return dp[node][k];
//    }
	
	
	private int[][] dp;
	private int h;
	private int[] p;
	
	public void TreeAncestor(int n, int[] parent) {
		h = (int)Math.sqrt(n);
        dp = new int[n][h];
        p = new int[n];
        Arrays.fill(p, -1);
        for(int i = 0; i < n; i++) {
        	Arrays.fill(dp[i], -1);
        	int cur = parent[i];
        	for(int j = 0; j < h; j++) {
        		dp[i][j] = cur;
        		if(cur == -1) break;
        		cur = parent[cur];
        	}
        	p[i] = cur;
        }
        
    }
    
    public int getKthAncestor(int node, int k) {
    	int i = k / (h+1);
    	int j = k % (h+1);
    	
    	for(int n = 0; n < i; n++) {
    		node = p[node];
    		if(node == -1) return -1;
    	}
    	
    	if(j == 0) return node;
    	return dp[node][j-1];
    }
    
    public static void main(String[] args) {
    	KthAncestorofaTreeNode test = new KthAncestorofaTreeNode();
    	int n = 7;
    	int[] parent = {-1,0,0,1,1,2,2};
    	test.TreeAncestor(n, parent);
    	System.out.println(test.getKthAncestor(3, 1));
    	System.out.println(test.getKthAncestor(5, 2));
    	System.out.println(test.getKthAncestor(6, 3));
    }
	
	
}
