import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PyramidTransitionMatrix {
	
	private HashMap<String, List<Character>> map = new HashMap<>();
	public boolean pyramidTransitionBFS(String bottom, List<String> allowed) {
		for(String str : allowed) {
			String prefix = str.substring(0,2);
			List<Character> l = map.getOrDefault(prefix, new ArrayList<Character>());
			l.add(str.charAt(2));
			map.put(prefix, l);
		}
		
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(bottom);
		HashSet<String> visited = new HashSet<String>();
		visited.add(bottom);
		while(!queue.isEmpty()) {
			String polled = queue.poll();
			List<String> res = new ArrayList<String>();
			candidate(polled, 0, res, new StringBuilder());
			
			if(res.size() > 0 && res.get(0).length() == 1) return true;
			for(String str : res) {
				if(!visited.contains(str)) {
					queue.add(str);
					visited.add(str);
				}
			}
		}
        
		return false;
    }
	
	public boolean pyramidTransitionDFS(String bottom, List<String> allowed) {
		for(String str : allowed) {
			String prefix = str.substring(0,2);
			List<Character> l = map.getOrDefault(prefix, new ArrayList<Character>());
			l.add(str.charAt(2));
			map.put(prefix, l);
		}
		HashSet<String> visited = new HashSet<String>();
		return dfs(bottom, visited);
    }
	
	boolean[][][] matrix = new boolean[7][7][7];
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		for(String str : allowed) {
			matrix[str.charAt(0)-'A'][str.charAt(1)-'A'][str.charAt(2)-'A'] = true;
		}
		HashSet<String> visited = new HashSet<String>();
		return dfs(bottom, visited);
    }
	
	private boolean dfs(String str, HashSet<String> visited) {
		if(visited.contains(str)) return false;
		
		List<String> res = new ArrayList<String>();
		candidate(str, 0, res, new StringBuilder());
		
		if(res.size() > 0 && str.length() == 2) return true;
		else {
			for(String can : res) {
				if(dfs(can, visited)) return true;
			}
		}
		return false;
	}
	
	private void candidate(String str, int i, List<String> res, StringBuilder sb){
		for(int k = 0; k < 7; k++) {
			if(matrix[str.charAt(i)-'A'][str.charAt(i+1)-'A'][k]) {
				sb.append((char)('A'+k));
				if(i == str.length()-2) res.add(sb.toString());
				else {
					candidate(str, i+1, res, sb);
				}
				sb.deleteCharAt(i);
			}
		}
	}
	
	private void candidateStr(String str, int i, List<String> res, StringBuilder sb){
		String prefix = "" + str.charAt(i) + str.charAt(i+1);
		
		if(!map.containsKey(prefix)) return;
		for(char c : map.get(prefix)) {
			if(i > 0) {
				String aux = "" + sb.charAt(i-1) + c;
				if(!map.containsKey(aux)) continue;
			}
			sb.append(c);
			if(i == str.length()-2) res.add(sb.toString());
			else {
				candidate(str, i+1, res, sb);
			}
			sb.deleteCharAt(i);
		}
	}
	
	public static void main(String[] args) {
		PyramidTransitionMatrix test = new PyramidTransitionMatrix();
		String bottom = "ABC";
		List<String> allowed = Arrays.asList("ABD","BCE","DEF","FFF");
		System.out.println(test.pyramidTransition(bottom, allowed));
	}
		
}
