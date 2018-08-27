
public class FlippinganImage {
	public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        
        int row = A.length;
        int col = A[0].length;
        
        for(int i = 0; i < A.length; i++) {
        	for(int j = 0; j < A[0].length; j++) {
        		result[i][j] = A[i][col-j-1] ^ 1;
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		
		
		System.out.println(1^1);
	}
}
