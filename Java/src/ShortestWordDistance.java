import java.util.ArrayList;
import java.util.Collections;

public class ShortestWordDistance {
	
	public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equals(word1)) list1.add(i);
        	if(words[i].equals(word2)) list2.add(i);
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
