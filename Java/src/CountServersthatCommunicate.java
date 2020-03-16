
public class CountServersthatCommunicate {
	
	public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == 1) {
        			rows[i]++;
        			cols[j]++;
        		}
        	}
        }
        
        int res = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == 1) {
        			if(rows[i] != 1 || cols[j] != 1) res++;
        		}
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		CountServersthatCommunicate test = new CountServersthatCommunicate();
		int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
		System.out.println(test.countServers(grid));
	
	}
	
}
