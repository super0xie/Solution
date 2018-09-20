import java.util.ArrayList;
import java.util.Collections;

public class BestMeetingPoint {
    
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> col = new ArrayList<Integer>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
                
            }
        }
        
        Collections.sort(col);
        int medRow = row.get(row.size()/2);
        int res = 0;
        int medCol = col.get(col.size()/2);
        
        for(int i = 0; i < row.size(); i++) {
            res += Math.abs(medRow - row.get(i));
        }
        
        for(int i = 0; i < col.size(); i++) {
            res += Math.abs(medCol - col.get(i));
        }
        return res;
        
    }

}
