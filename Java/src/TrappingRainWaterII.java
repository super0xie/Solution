import java.util.HashSet;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
	
	private class Cell{
		int i;
		int j;
		int h;
		Cell(int i, int j, int h){
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}
	
	public int trapRainWater(int[][] heightMap) {
		if(heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
		int m = heightMap.length;
		int n = heightMap[0].length;
		PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a,b)->{
			return a.h-b.h;
		});
		boolean [][] visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			pq.add(new Cell(i, 0, heightMap[i][0]));
			visited[i][0] = true;
			pq.add(new Cell(i, n-1, heightMap[i][n-1]));
			visited[i][n-1] = true;
		}
		
		for(int j = 1; j < n-1; j++) {
			pq.add(new Cell(0, j, heightMap[0][j]));
			visited[0][j] = true;
			pq.add(new Cell(m-1, j, heightMap[m-1][j]));
			visited[m-1][j] = true;
		}
		
		int res = 0;
		
		int[][] adj = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		while(!pq.isEmpty()) {
			Cell polled = pq.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = polled.i + adj[i][0];
				int c = polled.j + adj[i][1];
				
				if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
					if(polled.h > heightMap[r][c])
						res += polled.h - heightMap[r][c];
					pq.add(new Cell(r, c, Math.max(polled.h, heightMap[r][c])));
					visited[r][c] = true;
				}
			}
		}
		
		
		return res;
    }
	
	public static void main(String[] args) {
		int[][] heightMap = {{5,5,5,1},{5,1,1,5},{5,1,5,5},{5,2,5,8}};
		TrappingRainWaterII test = new TrappingRainWaterII();
		System.out.println(test.trapRainWater(heightMap));
	}

}
