
public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		if(image[sr][sc] == newColor) return image;
		
		boolean[][] visited = new boolean[image.length][image[0].length];
		floodFillHelper(image, sr, sc, image[sr][sc], newColor);
		return image;
    }
	
	private void floodFillHelper(int [][] image, int i, int j, int oldColor, int newColor) {
		if(i < 0 || i >= image.length || j < 0 || j >= image[0].length) return;
		if(image[i][j] != oldColor) return;
		
//		visited[i][]
		image[i][j] = newColor;
		
		floodFillHelper(image, i-1, j, oldColor, newColor);
		floodFillHelper(image, i+1, j, oldColor, newColor);
		floodFillHelper(image, i, j-1, oldColor, newColor);
		floodFillHelper(image, i, j+1, oldColor, newColor);
		
	}
	
	public static void main(String[] args) {
		FloodFill test = new FloodFill();
		int[][] image = {{0,0,0}, {1,1,0}};
		test.floodFill(image, 1, 1, 1);
	}

}
