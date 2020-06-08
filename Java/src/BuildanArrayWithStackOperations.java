import java.util.ArrayList;
import java.util.List;

public class BuildanArrayWithStackOperations {
	
	public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        for(int i = 1; i <= n; i++) {
        	if(i == target[idx]) {
        		res.add("Push");
        		idx++;
        		if(idx == target.length) break;
        	}else {
        		res.add("Push");
        		res.add("Pop");
        	}
        }
        return res;
    }
}
