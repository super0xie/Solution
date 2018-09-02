import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<String>();
        
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        
        ArrayList<String> words = new ArrayList<String>(wordList);
        words.add(beginWord);
        
        for(int i = 0; i < words.size(); i++) {
        	for(int j = i+1; j < words.size(); j++) {
        		if(diffOneDigit(words.get(i), words.get(j))) {
        			if(graph.containsKey(words.get(i))) {
        				graph.get(words.get(i)).add(words.get(j));
        			}else {
        				ArrayList<String> l = new ArrayList<String>();
        				l.add(words.get(j));
        				graph.put(words.get(i), l);
        			}
        			
        			if(graph.containsKey(words.get(j))) {
        				graph.get(words.get(j)).add(words.get(i));
        			}else {
        				ArrayList<String> l = new ArrayList<String>();
        				l.add(words.get(i));
        				graph.put(words.get(j), l);
        			}
        		}
        	}
        }
        list.add(beginWord);
        
        int count = 2;
        while(!list.isEmpty()) {
        	LinkedList<String> aux = new LinkedList<String>();
        	while(!list.isEmpty()) {
        		String poped = list.removeFirst();
        		visited.add(poped);
        		if(!graph.containsKey(poped)) continue;
        		for(String str : graph.get(poped)) {
        			if(!visited.contains(str)) {
        				if(str.equals(endWord)) return count;
        				aux.add(str);
        			}
        		}
        	}
        	list = aux;
        	count++;
        }
        
        return 0;
    }
	
	private boolean diffOneDigit(String str1, String str2) {
		int count = 0;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				count++;
				if(count > 1) return false;
			}
		}
		if(count == 1) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		WordLadder test = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		String [] wordArray = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = Arrays.asList(wordArray);
		System.out.println(test.ladderLength(beginWord, endWord, wordList));
	}

}
