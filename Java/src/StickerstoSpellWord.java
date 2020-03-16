import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StickerstoSpellWord {
	
	public int minStickers(String[] stickers, String target) {
        int[] count = new int[26];
        int n = 0;
        for(int i = 0; i < target.length(); i++) {
        	if(count[target.charAt(i)-'a'] == 0) n++;
        	count[target.charAt(i)-'a']++;
        }
        
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int cur = 0;
        int[] nCount = new int[n];
        for(int i = 0; i < 26; i++) {
        	if(count[i] > 0 && idx[i] < 0) {
        		idx[i] = cur++;
        		nCount[idx[i]] = count[i];
        	}
        }
        
        int[][] words = new int[stickers.length][n];
        
        for(int i = 0; i < stickers.length; i++) {
        	for(int j = 0; j < stickers[i].length(); j++) {
        		if(idx[stickers[i].charAt(j)-'a'] >= 0)
        			words[i][idx[stickers[i].charAt(j)-'a']]++;
        	}
        }
        
        boolean[] remove = new boolean[words.length];
        for(int i = 0; i < words.length; i++) {
        	for(int j = i+1; j < words.length; j++) {
        		int k = 0;
        		while(k < n && words[i][k] == words[j][k]) k++;
        		if(k == n) {
        			remove[i] = true;
        			continue;
        		}
        		
        		int l;
        		int s;
        		
        		if(words[i][k] > words[j][k]) {
        			l = i;
        			s = j;
        		}else {
        			l = j;
        			s = i;
        		}
        		
        		for(; k < n; k++) {
        			if(words[l][k] < words[s][k]) break;
        		}
        		
        		if(k == n) remove[s] = true;
        	}
        }
        
        ArrayList<int[]> l = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
        	if(!remove[i]) l.add(words[i]);
        }
        
        int res = helper(nCount, l, n, new HashMap<>(), new boolean[l.size()]);
        if(res == Integer.MAX_VALUE) return-1;
        return res;
    }
	
	private int helper(int[] count, ArrayList<int[]> words, int n, HashMap<Long, Integer> cache, boolean[] disabled) {
		long encode = 0;
		
		for(int i = 0; i < count.length; i++) {
			encode *= 16;
			encode += count[i];
		}
		if(cache.containsKey(encode)) return cache.get(encode);
		
		int res = Integer.MAX_VALUE;
		ArrayList<Integer> recover = new ArrayList<>();
		for(int i = 0; i < words.size(); i++) {
			if(disabled[i]) continue;
			boolean update = false;
			int[] cp = Arrays.copyOf(count, n);
			for(int j = 0; j < n; j++) {
				if(cp[j] <= 0 || words.get(i)[j] == 0) continue;
				cp[j] -= words.get(i)[j];
				update = true;
			}
			
			if(update) {
				int j = 0;
				for(; j < n; j++) {
					if(cp[j] > 0) break;
				}
				if(j == n) {
					res = 1;
					break;
				}
				
				int ret = helper(cp, words, n, cache, disabled);
				if(ret != Integer.MAX_VALUE)
					res = Math.min(res, ret+1);
			}else {
				disabled[i] = true;
				recover.add(i);
			}
		}
		
		for(int i : recover) disabled[i] = false;
		
		cache.put(encode, res);
		return res;
	}
	
	public static void main(String[] args) {
		StickerstoSpellWord test = new StickerstoSpellWord();
		String[] stickers = {"point","square","love","show","ran","certain","soil","period","say","human","duck","meet","speed","lie","differ","depend","thank","floor","sail","father","spring","field","music","too","interest","suit","new","finish","electric","parent","song","read","who","effect","fall","spoke","on","short","center","organ","plain","straight","near","so","she","science","quick","position","problem","history"};
		String target = "chargeresult";
		System.out.println(test.minStickers(stickers, target));
	}
	
}
