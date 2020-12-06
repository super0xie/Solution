import java.util.ArrayList;
import java.util.HashMap;

public class DetectPatternofLengthMRepeatedKorMoreTimes {
	
	public boolean containsPattern(int[] arr, int m, int k) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
        for(int i = 0; i + m - 1 < arr.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j = i; j <= i+m-1; j++) {
        		sb.append(arr[j] + ",");
        	}
        	
        	String s = sb.toString();
        	if(map.containsKey(s)) {
        		map.get(s).add(i);
        	} else {
        		ArrayList<Integer> l = new ArrayList<>();
        		l.add(i);
        		map.put(s, l);
        	}
        }
        
        for(String s : map.keySet()) {
        	ArrayList<Integer> l = map.get(s);
        	if(l.size() < k) continue;
        	
        	for(int i : l) {
        		int j = i + m;
        		for(j = i+m; j <= i + (k-1) * m; j += m) {
        			if(!l.contains(j)) break;
        		}
        		
        		if(j == i + k * m) return true;
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		DetectPatternofLengthMRepeatedKorMoreTimes test = new DetectPatternofLengthMRepeatedKorMoreTimes();
		int[] arr = {1,2,4,4,4,4};
		test.containsPattern(arr, 1, 3);
	}
	
}
