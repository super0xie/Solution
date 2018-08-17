import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
	
    public List<Integer> grayCode(int n) {
        if(n == 0) return new ArrayList<Integer>(Arrays.asList(0));
        else {
        	List<Integer> list = grayCode(n-1);
        	
        	int size = list.size();
        	int prefix = (int)Math.pow(2, n-1);
        	for(int i = size-1; i >=0; i--) {
        		list.add(list.get(i) + prefix);
        	}
        	
        	return list;
        }
    }

}
