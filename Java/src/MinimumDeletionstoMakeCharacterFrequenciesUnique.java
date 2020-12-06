import java.util.TreeMap;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
	
	public int minDeletions(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i)-'a']++;
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < count.length; i++) {
        	if(count[i] != 0)
        		map.put(count[i], map.getOrDefault(count[i], 0)+1);
        }
        while(!map.isEmpty()) {
        	int max = map.lastKey();
        	int c = map.get(max);
        	if(c > 1) {
        		res += c-1;
        		if(max>1)
        			map.put(max-1, map.getOrDefault(max-1, 0)+c-1);
        	}
        	map.remove(max);
        }
    	
        
        return res;
    }
	
	public static void main(String[] args) {
		MinimumDeletionstoMakeCharacterFrequenciesUnique test = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
		System.out.println(test.minDeletions("bbcebab"));
	}
	
	
	
}
