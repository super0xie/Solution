import java.util.LinkedList;

public class MatrixCellsinDistanceOrder {
	
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[R][C];
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {r0, c0});
        visited[r0][c0] = true;
        
        int idx = 0;
        
        while(!q.isEmpty()) {
        	int[] n = q.poll();
        	res[idx][0] = n[0];
        	res[idx][1] = n[1];
        	
        	for(int i = 0; i < 4; i++) {
        		int r = n[0] + adj[i][0];
        		int c = n[0] + adj[i][1];
        		
        		if(r >= 0 && r < R && c >= 0 && c < C && !visited[r][c]) {
        			visited[r][c] = true;
        			q.add(new int[] {r, c});
        		}
        	}
        	
        }
        
        return res;
    }
	
}
