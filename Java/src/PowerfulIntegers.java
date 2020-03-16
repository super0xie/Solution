import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulIntegers {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < 35; i++) {
			int base = (int)Math.pow(x, i);
			if(base > bound) break;
			for(int j = 0; j < 35; j++) {
				int n = base + (int)Math.pow(y, j);
				if(n > bound) break;
				else set.add(n);
			}
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		for(int i : set) {
			res.add(i);
		}
		return res;
        
    }
}
