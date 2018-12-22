import java.util.LinkedList;

public class ShortestBridge {
	private int m,n;
	private int[][] adj = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	public int shortestBridge(int[][] A) {
        m = A.length;
        n = A[0].length;
        
        boolean replaced = false;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(A[i][j] == 1) {
        			replace(A, i, j, 1);
        			replaced = true;
        			break;
        		}
        	}
        	if(replaced) break;
        }
        
        boolean bfsed = false;
        int res = Integer.MAX_VALUE;
        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		dis[i][j] = Integer.MAX_VALUE;
        	}
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(A[i][j] == 1) {
        			//bfs
        			LinkedList<int[]> queue = new LinkedList<>();
        			queue.add(new int[] {i, j});
        			dis[i][j] = 0;
        			while(!queue.isEmpty()) {
        				int[] poped = queue.poll();
        				for(int k = 0; k < 4; k++) {
        					int r = poped[0] + adj[k][0];
        					int c = poped[1] + adj[k][1];
        					if(r >= m || r < 0 || c >= n || c < 0) continue;
        					int newdis = 0;
        					if(A[r][c] != 1) newdis = dis[poped[0]][poped[1]] + 1;
        					if(newdis < dis[r][c]) {
        						dis[r][c] = newdis;
        						queue.add(new int [] {r, c});
        					}
        				}
        			}
        			
        			bfsed = true;
        			break;
        		}
        	}
        	if(bfsed) break;
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(A[i][j] == -1) res = Math.min(res, dis[i][j]-1);
        	}
        }
        return res;
        
    }
	
	private void replace(int[][] board, int i, int j, int target) {
        if(i >= m || i < 0 || j >= n || j < 0) return;
        if(board[i][j] != target) return;
        board[i][j] = -1;
        for(int k = 0; k < 4; k++) {
            replace(board, i+adj[k][0], j+adj[k][1], target);
        }
    }
	
	public static void main(String[] arsg) {
		int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		ShortestBridge test = new ShortestBridge();
		System.out.println(test.shortestBridge(A));
	}
}
