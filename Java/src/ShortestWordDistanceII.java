import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {
	private HashMap<String, List<Integer>> map;
	public void WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
        	List<Integer> list = map.get(words[i]);
        	if(list == null) {
        		list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(words[i], list);
        	}else {
        		list.add(i);
        	}
        }
        
    }
    
    public int shortest(String word1, String word2) {
    	List<Integer> list1 = map.get(word1);
    	List<Integer> list2 = map.get(word2);
    	
    	if(list1.size() < list2.size()) {
    		List<Integer> aux = list1;
    		list1 = list2;
    		list2 = aux;
    	}
    	int res = Integer.MAX_VALUE;
    	for(int i : list2) {
        	int bs = Collections.binarySearch(list1, i);
        	int ip = -bs - 1;
        	
        	if(ip == 0) {
        		res = Math.min(res, Math.abs(list1.get(0)-i));
        	}else if(ip == list1.size()) {
        		res = Math.min(res, Math.abs(list1.get(list1.size()-1)-i));
        	}else {
        		res = Math.min(Math.abs(list1.get(ip-1)-i), Math.min(res, Math.abs(list1.get(ip)-i)));
        	}
        	
        }
        return res;
    }
}
