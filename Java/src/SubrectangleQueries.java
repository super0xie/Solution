import java.util.ArrayList;

public class SubrectangleQueries {
	
	
	private int[][] m = null;
	ArrayList<int[]> updates = new ArrayList<>();
	public void SubrectangleQueries(int[][] rectangle) {
        m = rectangle;
    }
    
    public void updateSubrectangle(int r1, int c1, int r2, int c2, int v) {
        updates.add(new int[] {r1, c1, r2, c2, v});
    }
    
    public int getValue(int row, int col) {
        for(int i = updates.size()-1; i >= 0; i--) {
        	if(row >= updates.get(i)[0] && col >= updates.get(i)[1] && row <= updates.get(i)[2] && col <= updates.get(i)[3]) {
        		return updates.get(i)[4];
        	}
        }
        return m[row][col];
    }	
}
