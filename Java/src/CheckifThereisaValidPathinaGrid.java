import java.util.LinkedList;

public class CheckifThereisaValidPathinaGrid {
	
	public boolean hasValidPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        if(m == 1 && n == 1) return true;
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        int[][][] adj = {{}, 
        		{{0, -1}, {0, 1}}, 
        		{{-1, 0}, {1, 0}}, 
        		{{0, -1}, {1, 0}},
        		{{0, 1}, {1, 0}},
        		{{0, -1}, {-1, 0}},
        		{{0, 1}, {-1, 0}}
        		};
        
        int[][][] accept = {{},
        		{{1, 4, 6}, {1, 3, 5}},
        		{{2, 3, 4}, {2, 5, 6}},
        		{{1, 4, 6}, {2, 5, 6}},
        		{{1, 3, 5}, {2, 5, 6}},
        		{{1, 4, 6}, {2, 3, 4}},
        		{{1, 3, 5}, {2, 3, 4}}
        		};
        
        while(!q.isEmpty()) {
        	int[] poll = q.poll();
        	int s = grid[poll[0]][poll[1]];
        	
        	for(int k = 0; k < adj[s].length; k++) {
        		int r = poll[0] + adj[s][k][0];
        		int c = poll[1] + adj[s][k][1];
        		
        		if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
        			int i = 0;
        			for(;i < accept[s][k].length; i++) {
        				if(accept[s][k][i] == grid[r][c]) break;
        			}
        			if(i < accept[s][k].length) {
        				visited[r][c] = true;
        				if(r == m-1 && c == n-1) return true;
        				q.add(new int[] {r, c});
        			}
        		}
        	}
        	
        }
        
        return false;
        
    }
	
	public static void main(String[] args) {
		int[][] grid = {{2,4,3},{6,5,2}};
		CheckifThereisaValidPathinaGrid test = new CheckifThereisaValidPathinaGrid();
		System.out.println(test.hasValidPath(grid));
	}
	
}
