
public class FindSmallestCommonElementinAllRows {
	
	public int smallestCommonElement(int[][] mat) {
        int[] inds = new int[mat.length];
        int m = mat.length;
        int n = mat[0].length;
        
        for(int j = 0; j < n; j++) {
        	int num = mat[0][j];
        	int i = 1;
        	for(; i < m; i++) {
        		while(inds[i] < n && mat[i][inds[i]] < num) inds[i]++;
        		if(inds[i] == n) return -1;
        		if(mat[i][inds[i]] > num) break;
        	}
        	
        	if(i == m) return num; 
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		FindSmallestCommonElementinAllRows test = new FindSmallestCommonElementinAllRows();
		int[][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
		System.out.println(test.smallestCommonElement(mat));
	}
	
	
}
