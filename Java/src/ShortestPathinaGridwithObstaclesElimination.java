import java.util.LinkedList;

public class ShortestPathinaGridwithObstaclesElimination {
	
	class Node{
		int i;
		int j;
		int k;
		
		Node(int i, int j, int k){
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}
	
	public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return 0;
        
        int[][] adj = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        LinkedList<Node> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) visited[i][j] = -1;
        }
        
        visited[0][0] = k;
        q.add(new Node(0, 0, k));
        
        
        int step = 1;
        while(!q.isEmpty()) {
        	LinkedList<Node> aux = new LinkedList<>();
        	
        	while(!q.isEmpty()) {
        		Node p = q.poll();
        		
        		for(int i = 0; i < adj.length; i++) {
        			int r = adj[i][0] + p.i;
        			int c = adj[i][1] + p.j;
        			
        			if(r >= 0 && r < m && c >= 0 && c < n) {
        				if(r == m-1 && c == n-1) return step;
        				if(grid[r][c] == 1 && visited[r][c] < p.k-1) {
        					visited[r][c] = p.k-1;
        					aux.add(new Node(r, c, p.k-1));
        				}else if(grid[r][c] == 0 && visited[r][c] < p.k) {
        					visited[r][c] = p.k;
        					aux.add(new Node(r, c, p.k));
        				}
        			}
        		}
        		
        	}
        	q = aux;
        	step++;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		ShortestPathinaGridwithObstaclesElimination test = new ShortestPathinaGridwithObstaclesElimination();
		int[][] grid = {{0,1,1},
				 {1,1,1},
				 {1,0,0}};
		System.out.println(test.shortestPath(grid, 1));
	}
	
}
