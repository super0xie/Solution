import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < S.length()-1; i++) {
        	int j = i + 1;
        	while(j < S.length() && S.charAt(j) == S.charAt(i)) j++;
        	if(j - i >= 3) {
        		List<Integer> l = new ArrayList<>();
        		l.add(i);
        		l.add(j-1);
        		res.add(l);
        	}
        	
        	i = j-1;
        }
        
        return res;
    }
}
