import java.util.Arrays;
import java.util.LinkedList;

public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix {
	
	private int[] bitmask = {1, 2, 4, 8, 16, 32, 64, 128, 256};
	
	public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        
        boolean[] flat = new boolean[m * n];
        int idx = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		flat[idx++] = mat[i][j] == 1;
        	}
        }
        
        
        boolean[] visited = new boolean[512];
        
        
        int v = encode(flat);
        if(v == 0) return 0;
        
        LinkedList<boolean[]> q = new LinkedList<>(); 
        q.add(flat);
        visited[v] = true;
        int step = 1;
        while(!q.isEmpty()) {
        	LinkedList<boolean[]> aux = new LinkedList<>();
        	
        	while(!q.isEmpty()) {
        		boolean[] p = q.poll();
        		
        		for(int i = 0; i < p.length; i++) {
        			boolean[] cp = Arrays.copyOf(p, p.length);
        			cp[i] = !cp[i];
        			int up = i - n;
        			int down = i + n;
        			
        			if(up >= 0) cp[up] = !cp[up];
        			if(down < cp.length) cp[down] = !cp[down];
        			if(i % n != 0) cp[i-1] = !cp[i-1];
        			if(i % n != n-1) cp[i+1] = !cp[i+1];
        			
        			int encode = encode(cp);
        			if(encode == 0) return step;
        			if(!visited[encode]) {
        				visited[encode] = true;
        				aux.add(cp);
        			}
        		}
        		
        	}
        	
        	step++;
        	q = aux;
        	
        }
        
        return -1;
    }
	
	private int encode(boolean[] mat) {
		int res = 0;
		for(int i = 0; i < mat.length; i++) {
			if(mat[i]) {
				res = res | bitmask[i];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix test = new MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix();
		int[][] mat = {{1,0,0},{1,0,0}};
		System.out.println(test.minFlips(mat));
	}
}
