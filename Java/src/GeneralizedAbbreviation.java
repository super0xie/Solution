import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GeneralizedAbbreviation {
	
	private HashMap<String, List<String>> map = new HashMap<>();
	
	public List<String> generateAbbreviations(String word) {
		if(map.containsKey(word)) return map.get(word);
		
		if(word.length() == 0) return Arrays.asList("");
        if(word.length() == 1) return Arrays.asList(word, "1");
        else {
        	HashSet<String> set = new HashSet<String>();
        	set.add(String.valueOf(word.length()));
        	for(int i = 0; i < word.length(); i++) {
        		List<String> l = generateAbbreviations(word.substring(0, i));
        		List<String> r = generateAbbreviations(word.substring(i+1, word.length()));
        		for(int j = 0; j < l.size(); j++) {
        			for(int k = 0; k < r.size(); k++) {
        				set.add(l.get(j) + word.charAt(i) + r.get(k));
        			}
        		}
        	}
        	List<String> res = new ArrayList<String>();
        	res.addAll(set);
        	map.put(word, res);
        	return res;
        }
    }
	
	public static void main(String[] args) {
		GeneralizedAbbreviation test = new GeneralizedAbbreviation();
		List<String> res = test.generateAbbreviations("word");
		System.out.println("test");
	}
}
