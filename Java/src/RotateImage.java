
public class RotateImage {
	
	int [][] matrix;
	
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        //up down swap
        for(int i = 0; i < matrix.length / 2; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		swap(i, j, matrix.length-1-i, j);
        	}
        }
        
        //diagonal swap
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = i+1; j < matrix[0].length; j++) {
        		swap(i, j, j, i);
        	}
        }
        
    }
    
    private void swap(int si, int sj, int di, int dj) {
    	int aux = matrix[si][sj];
    	matrix[si][sj] = matrix[di][dj];
    	matrix[di][dj] = aux;
    }
    
    public static void main(String[] args) {
    	RotateImage test = new RotateImage();
    	int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    	test.rotate(matrix);
    	
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			System.out.print(matrix[i][j]);
    		}
    		System.out.print("\n");
    		
    	}
    	
 	
    			
    }

}
