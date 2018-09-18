import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GuesstheWord {
	
	interface Master {
		public int guess(String word);
	}
	
	public void findSecretWord1(String[] wordlist, Master master) {
        ArrayList<String> list = new ArrayList<String>();
        for(String str : wordlist) list.add(str);
      
        for(int ind = 0; ind < 10; ind++) {
        	
        	HashMap<String, Integer> map = new HashMap<String, Integer>();
    		for(int i = 0; i < list.size(); i++) {
    			for(int j = i+1; j < list.size(); j++) {
    				if(match(list.get(i), list.get(j)) == 0) {
    					map.put(list.get(i), map.getOrDefault(list.get(i), 0)+1);
    					map.put(list.get(j), map.getOrDefault(list.get(j), 0)+1);
    				}
    			}
    		}
        	String str = null;
        	int min = Integer.MAX_VALUE;
        	
        	for(String word : list) {
        		int count = map.getOrDefault(word, 0);
        		if(count < min) {
        			min = count;
        			str = word;
        		}
        	}
        	
        	int match = master.guess(str);
        	if(match == 6) return;
        	ArrayList<String> aux = new ArrayList<String>();
        	
        	for(String word : list) {
        		if(match(str, word) == match) aux.add(word);
        	}
        	list = aux;
        }
        
    }
	
	public void findSecretWord(String[] wordlist, Master master) {
        ArrayList<String> list = new ArrayList<String>();
        for(String str : wordlist) list.add(str);
        Random r = new Random();
        for(int ind = 0; ind < 10; ind++) {
        	String str = list.get(r.nextInt(list.size()));
        	int match = master.guess(str);
        	if(match == 6) return;
        	ArrayList<String> aux = new ArrayList<String>();
        	
        	for(String word : list) {
        		if(match(str, word) == match) aux.add(word);
        	}
        	list = aux;
        }
        
    }
	
	private int match(String str1, String str2) {
		int res = 0;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) == str2.charAt(i)) res++;
		}
		return res;
	}

}
