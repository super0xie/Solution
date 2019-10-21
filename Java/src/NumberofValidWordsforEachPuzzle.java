import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberofValidWordsforEachPuzzle {
	
	public List<Integer> findNumOfValidWordsOld(String[] words, String[] puzzles) {
        boolean[][] counts = new boolean[words.length][26];
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) {
        	for(int j = 0; j < words[i].length(); j++) {
        		counts[i][words[i].charAt(j)-'a'] = true;
        	}
        }
        
        for(int i = 0; i < puzzles.length; i++) {
        	int count = 0;
        	boolean[] cur = new boolean[26];
        	for(int j = 0; j < puzzles[i].length(); j++) {
        		cur[puzzles[i].charAt(j)-'a'] = true;
        	}
        	
        	for(int j = 0; j < words.length; j++) {
        		if(!counts[j][puzzles[i].charAt(0)-'a']) continue;
        		int k = 0;
        		for(; k < 26; k++) {
        			if(counts[j][k] && !cur[k]) break;
        		}
        		if(k == 26) count++;
        	}
        	res.add(count);
        }
        
        return res;
    }
	
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) {
        	boolean[] cur = new boolean[26];
        	int c = 0;
        	for(int j = 0; j < words[i].length(); j++) {
        		if(!cur[words[i].charAt(j)-'a']) c++;
        		cur[words[i].charAt(j)-'a'] = true;
        	}
        	if(c > 7) continue;
        	
        	int encode = encode(cur);
        	map.put(encode, map.getOrDefault(encode, 0)+1);
        }
        
        for(int i = 0; i < puzzles.length; i++) {
        	int count = 0;
        	boolean[] cur = new boolean[26];
        	for(int j = 0; j < puzzles[i].length(); j++) {
        		cur[puzzles[i].charAt(j)-'a'] = true;
        	}
        	int encode = encode(cur);
        	int first = 1 << (puzzles[i].charAt(0)-'a');
        	
        	ArrayList<Integer> l = new ArrayList<>();
        	helper(0, cur, l);
        	
        	for(int sub : l) {
        		if((sub | first) == sub && map.containsKey(sub)) count += map.get(sub);
        	}
        	
        	res.add(count);
        }
        
        return res;
    }
	
	private void helper(int i, boolean[] count, ArrayList<Integer> l) {
		if(i == 26) {
			l.add(encode(count));
			return;
		}
		
		if(!count[i]) {
			helper(i+1, count, l);
		}else {
			helper(i+1, count, l);
			count[i] = false;
			helper(i+1, count, l);
			count[i] = true;
		}
		
	}
	
	private int encode(boolean[] count) {
		int encode = 0;
		for(int i = 25; i >= 0; i--) {
			encode = encode << 1;
			if(count[i]) encode += 1;
		}
		return encode;
	}
	
	public static void main(String[] args) {
		NumberofValidWordsforEachPuzzle test = new NumberofValidWordsforEachPuzzle();
		String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
		String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		List<Integer> res = test.findNumOfValidWords(words, puzzles);
		for(int i : res) System.out.print(i + ", ");
	}
	
}
