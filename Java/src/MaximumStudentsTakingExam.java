import java.util.ArrayList;
import java.util.HashMap;

public class MaximumStudentsTakingExam {
	
	private int m;
	private int n;
	public int maxStudents(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ArrayList<int[]> l = new ArrayList<>();
        int res = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(grid[i][j] == '.') {
        			boolean hasAdj = false;
        			for(int r = i-1; r <= i+1; r++) {
        				for(int c = j-1; c <= j+1; c += 2){
        					if(r >= 0 && r < m && c >= 0 && c < n) {
        						if(grid[r][c] == '.') {
        							hasAdj = true;
        							break;
        						}
        					}
        					if(hasAdj) break;
        				}
        			}
        			
        			if(hasAdj)
        				l.add(new int[] {i, j});
        			else
        				res += 1;
        		}
        	}
        }
        
        boolean[][] disable = new boolean[m][n];
        
        return res + helper(l, 0, disable, new HashMap<>());
        
    }
	
	private int helper(ArrayList<int[]> l, int i, boolean[][] disable, HashMap<String, Integer> cache) {
		if(i == l.size()) return 0;
		StringBuilder sb = new StringBuilder();
		
		for(int k = i; k < l.size(); k++) {
			if(disable[l.get(k)[0]][l.get(k)[1]]) {
				sb.append('0');
			}else {
				sb.append('1');
			}
		}
		
		String encode = sb.toString();

		if(cache.containsKey(encode)) {
			return cache.get(encode);
		}		

		int[] p = l.get(i);
		
		int res = helper(l, i+1, disable, cache);
		
		if(!disable[p[0]][p[1]]) {
			ArrayList<int[]> recover = new ArrayList<>();
			for(int r = p[0]-1; r <= p[0]+1; r++) {
				for(int c = p[1]-1; c <= p[1]+1; c+=2){
					if(r >= 0 && r < m && c >= 0 && c < n) {
						if(!disable[r][c]) {
							recover.add(new int[] {r, c});
							disable[r][c] = true;
						}
					}
				}
			}
			
			res = Math.max(res, helper(l, i+1, disable, cache)+1);
			
			for(int[] r : recover) {
				disable[r[0]][r[1]] = false;
			}
		}
		
		cache.put(encode, res);
		return res;
	}
	
	public static void main(String[] args) {
		MaximumStudentsTakingExam test = new MaximumStudentsTakingExam();
		char[][] grid = {{'.','.','.','.','#','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','#','.'},{'.','.','.','.','.','.','.','.'},{'.','.','#','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','#','.','.','#','.'}};
		System.out.println(test.maxStudents(grid));
		
		
	}
	
}
