
public class Searcha2DMatrixII {
	
	private static int searchInsert(int[][] matrix, int target, boolean horizontal, int start, int end, int index) {
        int mid = 0;
        int midValue = 0;
        while(start <= end) {
            mid = start + (end - start)/2;         
            if(horizontal)
            	midValue = matrix[index][mid];
            else
            	midValue = matrix[mid][index];
            
            if(midValue == target) return mid;
            if(midValue < target) start = mid+1;
            else end = mid - 1;
        }
        
        if(target > midValue) return mid+1;
        else return mid;
    }
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row == 0) return false;
		int col = matrix[0].length;
		if(col == 0) return false;
		
		int rowUpperBound = searchInsert(matrix, target, false, 0, row-1, 0);
		if(rowUpperBound < row && matrix[rowUpperBound][0] == target) return true;
		if(rowUpperBound == 0) return false;
		rowUpperBound--;
		
		int rowLowerBound = searchInsert(matrix, target, false, 0, row-1, col-1);
		if(rowLowerBound < row && matrix[rowLowerBound][col-1] == target) return true;
		if(rowLowerBound == row) return false;
		
		int colUpperBound = searchInsert(matrix, target, true, 0, col-1, 0);
		if(colUpperBound < col && matrix[0][colUpperBound] == target) return true;
		if(colUpperBound == 0) return false;
		colUpperBound--;
		
		int colLowerBound = searchInsert(matrix, target, true, 0, col-1, row-1);
		if(colLowerBound < col && matrix[row-1][colLowerBound] == target) return true;
		if(colLowerBound == col) return false;
		
		for(int i = rowLowerBound; i <= rowUpperBound; i++) {
			int result = searchInsert(matrix, target, true, colLowerBound, colUpperBound, i);
			if(result < col && matrix[i][result] == target) return true;
		}
		
		return false;

    }
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		
//		System.out.println(Searcha2DMatrixII.searchInsert(matrix, 5, false, 0, 4, 0));
		Searcha2DMatrixII test = new Searcha2DMatrixII();
		System.out.println(test.searchMatrix(matrix, 20));
	}
}
