import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	ArrayList<Integer> result;
	boolean [][] visited;
	int m;
	int n;
	int counter;
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	result = new ArrayList<Integer>();
    	if(matrix.length == 0 || matrix[0].length == 0) {
    		return result;
    	}
    	
    	m = matrix.length;
    	n = matrix[0].length;
    	counter = 0;
    	visited = new boolean [m][n];
    	helper(matrix, 0, 0, 0);
    	
    	return result;
    }
    
    private void helper(int[][] matrix, int i, int j, int dir) {
    	
    	result.add(matrix[i][j]);
    	visited[i][j] = true;
    	counter++;
    	if(counter == m * n) return;
    	
    	switch(dir) {
    	case 0:{
    		if(j == n-1 || visited[i][j+1])  helper(matrix, i+1, j, 1);
    		else helper(matrix, i, j+1, 0);
    		break;	
    	}
    	case 1:{
    		if(i == m-1 || visited[i+1][j]) helper(matrix, i, j-1, 2);
    		else helper(matrix, i+1, j, 1);
    		break;
    	}
    	case 2:{
    		if(j == 0 || visited[i][j-1]) helper(matrix, i-1, j, 3);
    		else helper(matrix, i, j-1, 2);
    		break;
    	}
    	case 3:{
    		if(i == 0 || visited[i-1][j]) helper(matrix, i, j+1, 0);
    		else helper(matrix, i-1, j, 3);
    		break;
    	}
    	}
    	
    }
    
    public static void main(String[] args) {
    	SpiralMatrix test = new SpiralMatrix();
    	int [][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
    	System.out.println(test.spiralOrder(matrix));
    }
}
