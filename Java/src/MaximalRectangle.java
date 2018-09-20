import java.util.HashMap;

public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
        	int start = -1;
        	int end = -1;
        	HashMap<Integer, Integer> cur = new HashMap<Integer, Integer>();
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			start = j;
        			end = j;
        			while(end+1 < matrix[0].length && matrix[i][end+1] == '1') end++;
        			for(int m = start; m <= end; m++) {
        				for(int n = m; n <= end; n++) {
        					if(map.containsKey(200*m+n)) {
        						cur.put(200*m+n, map.get(200*m+n)+1);
        						res = Math.max(res, (n-m+1) * (map.get(200*m+n)+1));
        					}else {
        						cur.put(200*m+n, 1);
        						res = Math.max(res, n-m+1);
        					}
        				}
        			}
        			
        			j=end;
        		}
        		
        	}
        	map = cur;
        }
        return res;
    }
	
	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		char[][] matrix = {
				  {'1','0','1','0','0'},
				  {'1','0','1','1','1'},
				  {'1','1','1','1','1'},
				  {'1','0','0','1','0'}
				};
		System.out.println(test.maximalRectangle(matrix));
	}

}
