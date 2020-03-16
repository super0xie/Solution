import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
	
	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> res = new ArrayList<>();
		int n = 0;
		for(int i : A) {
			n = n * 2;
			n = n + i;
			if(n % 5 == 0) res.add(true);
			else res.add(false);
			n = n % 5;
		}
		return res;
    }
	
}
