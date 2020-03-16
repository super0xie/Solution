import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SynonymousSentences {
	
	public List<String> generateSentences(List<List<String>> synonyms, String text) {
		HashMap<String, Integer> map = new HashMap<>();
		int cur = 0;
		for(List<String> pair : synonyms) {
			if(!map.containsKey(pair.get(0))) {
				map.put(pair.get(0), cur++);
			}
			if(!map.containsKey(pair.get(1))) {
				map.put(pair.get(1), cur++);
			}
		}
		
		int[] uf = new int[map.size()];
		for(int i = 0; i < uf.length; i++) uf[i] = i;
		
		for(List<String> pair : synonyms) {
			union(uf, map.get(pair.get(0)), map.get(pair.get(1)));
		}
		
		HashMap<Integer, ArrayList<String>> groups = new HashMap<>();
		for(String str : map.keySet()) {
			int root = getRoot(uf, map.get(str));
			if(!groups.containsKey(root)) groups.put(root, new ArrayList<>());
			groups.get(root).add(str);
		}
		
		for(int i : groups.keySet()) {
			Collections.sort(groups.get(i));
		}
		
		String[] strs = text.split(" ");
		String[] arr = new String[strs.length];
		
		List<String> res = new ArrayList<>();
		
		
		dfs(strs, 0, arr, res, map, groups, uf);
		
		
		return res;
	}
	
	private void dfs(String[] strs, int i, String[] arr, List<String> res, HashMap<String, Integer> map, HashMap<Integer, ArrayList<String>> groups, int[] uf) {
		
		if(i == strs.length) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < arr.length; j++) {
				sb.append(arr[j]);
				if(j != arr.length-1) sb.append(" ");
			}
			res.add(sb.toString());
		}else {
			if(map.containsKey(strs[i])) {
				int root = getRoot(uf, map.get(strs[i]));
				List<String> group = groups.get(root);
				
				for(String s : group) {
					arr[i] = s;
					dfs(strs, i+1, arr, res, map, groups, uf);
				}
				
			} else {
				arr[i] = strs[i];
				dfs(strs, i+1, arr, res, map, groups, uf);
			}
			
		}
		
	}
	
	
	private int getRoot(int[] uf, int i) {
		if(uf[i] == i) return i;
		else {
			int r = getRoot(uf, uf[i]);
			uf[i] = r;
			return r;
		}
	}
	
	private void union(int[] uf, int i, int j) {
		int r1 = getRoot(uf, i);
		int r2 = getRoot(uf, j);
		
		if(r1 != r2)
			uf[r1] = r2;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"happy","joy"},{"sad","sorrow"},{"joy","cheerful"}};
		String text = "I am happy today but was sad yesterday";
		SynonymousSentences test = new SynonymousSentences();
//		List<String> res = test.foo(text, pairs);
		
		System.out.println("test");
		
	}
	
}
