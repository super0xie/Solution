import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < numRows; i++) {
			List<Integer> previousList = null;
			if(i > 1) previousList = result.get(result.size()-1);
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					list.add(1);
				}else {
					list.add(previousList.get(j-1) + previousList.get(j));
				}
			}
			
			result.add(list);
		}

		return result;
    }

}
