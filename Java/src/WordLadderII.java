import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordLadderII {

    public List<List<String>> findLaddersOld(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        ArrayList<String> words = new ArrayList<String>();
        for(String str : wordList){
            words.add(str);
        }
        if(!words.contains(beginWord)) words.add(beginWord);
        
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
        map.put(beginWord, new ArrayList<>());

        while(!list.isEmpty()) {
            LinkedList<String> aux = new LinkedList<String>();
            HashMap<String, ArrayList<String>> toAddMap = new HashMap<>();
            
        	while(!list.isEmpty()) {
        		String poped = list.removeFirst();
        		
        		if(!graph.containsKey(poped)) continue;
        		for(String str : graph.get(poped)) {
        			if(!map.containsKey(str)) {
                        if(toAddMap.containsKey(str)){
                            toAddMap.get(str).add(poped);
                        }else{
                            ArrayList<String> l = new ArrayList<>();
                            l.add(poped);
                            toAddMap.put(str, l);
                            aux.add(str);
                        }
        			}
        		}
            }
            
            list = aux;
            map.putAll(toAddMap);
            if(toAddMap.containsKey(endWord)) break;
        }

        List<List<String>> res = new ArrayList<>();

        if(map.containsKey(endWord)){
            dfs(endWord, new LinkedList<>(), res, map);
        }

        return res;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        LinkedList<String> list = new LinkedList<String>();
        
        list.add(beginWord);
        map.put(beginWord, new ArrayList<>());

        while(!list.isEmpty()) {
            LinkedList<String> aux = new LinkedList<String>();
            HashMap<String, ArrayList<String>> toAddMap = new HashMap<>();
            
        	while(!list.isEmpty()) {
        		String poped = list.removeFirst();
        		
        		for(String str : wordList){
                    if(!map.containsKey(str) && diffOneDigit(poped, str)){
                        if(toAddMap.containsKey(str)){
                            toAddMap.get(str).add(poped);
                        }else{
                            ArrayList<String> l = new ArrayList<>();
                            l.add(poped);
                            toAddMap.put(str, l);
                            aux.add(str);
                        }
                    }
                }
            }
            
            list = aux;
            map.putAll(toAddMap);
            if(toAddMap.containsKey(endWord)) break;
        }

        List<List<String>> res = new ArrayList<>();

        if(map.containsKey(endWord)){
            dfs(endWord, new LinkedList<>(), res, map);
        }

        return res;
    }

    private void dfs(String str, LinkedList<String> l, List<List<String>> res, HashMap<String, ArrayList<String>> map){
        l.addFirst(str);
        ArrayList<String> prevs = map.get(str);
        if(prevs.isEmpty()){
            ArrayList<String> copy = new ArrayList<>(l);
            res.add(copy);
        }else{
            for(String prev : map.get(str)){
                dfs(prev, l, res, map);
            }
        }
        l.removeFirst();
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
        WordLadderII test = new WordLadderII();
        List<List<String>> res = test.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        for(List<String> l : res){
            for(String str : l){
                System.out.print(str + ", ");
            }
            System.out.println("");
        }
    }

}