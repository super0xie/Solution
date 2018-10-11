import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		if(rowIndex == 0) return Arrays.asList(1);
		if(rowIndex == 1) return Arrays.asList(1, 1);
        int [] pre = new int[rowIndex+1];
        int [] cur = null;
        
        pre[0] = 1;
        pre[1] = 1;
        for(int i = 2; i <= rowIndex; i++) {
        	cur = new int[rowIndex+1];
        	cur[0] = 1;
        	cur[i] = 1;
        	
        	for(int j = 1; j < i; j++) {
        		cur[j] = pre[j-1] + pre[j];
        	}
        	pre = cur;
        }
        
        
        for(int i = 0; i <= rowIndex; i++) {
        	res.add(cur[i]);
        }
        return res;
    }
}
