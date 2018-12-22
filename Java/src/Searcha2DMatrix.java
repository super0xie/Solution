
public class Searcha2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
        int l = 0;
        int r = matrix.length-1;
        if(matrix[0][0] > target) return false;
        if(matrix[m-1][n-1] < target) return false;
        while(l < r) {
        	int mid = r - (r-l)/2;
        	if(matrix[mid][0] > target) r = mid-1;
        	else l = mid;
        }
        
        
        int aux = l;
        l = 0;
        r = n-1;
        
        while(l <= r) {
        	int mid = l + (r-l)/2;
        	if(matrix[aux][mid] == target) return true;
        	else if(matrix[aux][mid] > target) r = mid-1;
        	else l = mid+1;
        }
        
        return false;
    }

}
