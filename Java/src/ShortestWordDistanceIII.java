import java.util.ArrayList;
import java.util.Collections;

public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equals(word1)) list1.add(i);
        	if(words[i].equals(word2)) list2.add(i);
        }
        
        int res = Integer.MAX_VALUE;
        if(word1.equals(word2)) {
        	for(int i = 0; i < list1.size()-1; i++) {
        		res = Math.min(res, list1.get(i+1)-list1.get(i));
        	}
        	return res;
        }else {
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
	
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistanceIII test = new ShortestWordDistanceIII();
		test.shortestWordDistance(words, "makes", "coding");
	}

}
