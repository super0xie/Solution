import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class SmallestStringWithSwaps {
	

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int[] uf = new int[s.length()];
        for(int i = 0; i < uf.length; i++) uf[i] = i;
        for(List<Integer> l : pairs) {
        	union(uf, l.get(0), l.get(1));
        }
        
        HashMap<Integer, ArrayList[]> map = new HashMap<>();
        for(int i = 0; i < uf.length; i++) {
        	int r = getRoot(uf, i);
        	if(!map.containsKey(r)) {
        		map.put(r, new ArrayList[] {new ArrayList<Integer>(), new ArrayList<Character>()});
        	}
        	ArrayList[] arr = map.get(r);
        	arr[0].add(i);
        	arr[1].add(s.charAt(i));
        }
        
        char[] chars = new char[s.length()];
        for(int i : map.keySet()) {
        	ArrayList<Integer> indices = map.get(i)[0];
        	ArrayList<Character> c = map.get(i)[1];
        	Collections.sort(c);
        	
        	for(int j = 0; j < c.size(); j++) {
        		chars[indices.get(j)] = c.get(j);
        	}
        }
        
        return String.valueOf(chars);
    }
	
	private int getRoot(int[] uf, int i){
        if(uf[i] == i) return i;
        else {
            int r = getRoot(uf, uf[i]);
            uf[i] = r;
            return r;
        }
    }

    private void union(int[] uf, int i, int j){
        int r1 = getRoot(uf, i);
        int r2 = getRoot(uf, j);
        if(r1 != r2)
            uf[r1] = r2;
    }
    
    public static void main(String[] args) {
    	SmallestStringWithSwaps test = new SmallestStringWithSwaps();
    	List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2));
    	System.out.println("" + test.smallestStringWithSwaps("dcab", pairs));
    }

}
