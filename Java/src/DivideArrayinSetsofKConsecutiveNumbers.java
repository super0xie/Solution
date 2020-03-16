import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {
	
	public boolean isPossibleDivide(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i : nums) 
			map.put(i, map.getOrDefault(i, 0)+1);
		
		
		while(!map.isEmpty()) {
			int start = map.firstKey();
			for(int i = start; i < start + k; i++) {
				if(!map.containsKey(i)) return false;
				
				if(map.get(i) == 1) map.remove(i);
				else map.put(i, map.get(i)-1);
				
			}
			
		}
		
		
		return true;
    }
	
}
