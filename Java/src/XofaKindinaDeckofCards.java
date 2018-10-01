import java.util.ArrayList;
import java.util.List;

public class XofaKindinaDeckofCards {
	
	public boolean hasGroupsSizeX(int[] deck) {
		int [] count = new int [10000];
		for(int i : deck) {
			count[i]++;
		}
		
		int min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			if(count[i] > 0) {
				min = Math.min(min, count[i]);
				list.add(count[i]);
			}
		}
		
		if(min == 1) return false;
		for(int i = 2; i <= min; i++) {
			int j = 0;
			for(; j < list.size(); j++) {
				if(list.get(j) % i != 0) break;
			}
			if(j == list.size()) return true;
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] deck = {1,1,1,1,2,2,2,2,2,2};
		XofaKindinaDeckofCards test = new XofaKindinaDeckofCards();
		System.out.println(test.hasGroupsSizeX(deck));
				
	}

}
