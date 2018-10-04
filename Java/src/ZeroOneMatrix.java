import java.util.LinkedList;

public class ZeroOneMatrix {
    
    
    
	public int[][] updateMatrix(int[][] matrix) {
	    
	    int[][] res = new int[matrix.length][matrix[0].length];
	    
	    LinkedList<int[]> queue = new LinkedList<int[]>();
	    
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            if(matrix[i][j] == 0) {
	                queue.add(new int[] {i, j, 0});
	            }else {
	                res[i][j] = Integer.MAX_VALUE;
	            }
	        }
	    }
	    
	    int[][] adj = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	    
	    while(!queue.isEmpty()) {
	        int[] polled = queue.poll();
	        
	        for(int i = 0; i < 4; i++) {
	            int r = polled[0] + adj[i][0];
	            int c = polled[1] + adj[i][1];
	            int d = polled[2] + 1;
	            if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
	                if(d >= res[r][c]) continue;
	                
	                res[r][c] = d;
	                queue.add(new int[] {r, c, d});
	            }
	            
	        }
	        
	    }
	    
        return res;
    }
	
	public static void main(String[] args) {
	    ZeroOneMatrix test = new ZeroOneMatrix();
	    int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
	    test.updateMatrix(matrix);
	}

}
