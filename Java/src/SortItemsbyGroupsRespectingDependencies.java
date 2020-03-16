import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SortItemsbyGroupsRespectingDependencies {
	
	private boolean hasCycle = false;
	
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int cur = m;
        for(int i = 0; i < group.length; i++) {
        	if(group[i] == -1) group[i] = cur++;
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < group.length; i++) {
        	if(!map.containsKey(group[i])) map.put(group[i], new HashSet<>());
        	map.get(group[i]).add(i);
        }
        
        ArrayList<ArrayList<Integer>> groupGraph = new ArrayList<>();
        for(int i = 0; i < cur; i++) {
        	groupGraph.add(new ArrayList<>());
        }
        for(int i = 0; i < beforeItems.size(); i++) {
        	for(int j : beforeItems.get(i))
        		if(group[i] != group[j])
        			groupGraph.get(group[i]).add(group[j]);
        }
        
        LinkedList<Integer> l = new LinkedList<>();
        
        boolean[] visited = new boolean[cur];
    	boolean[] onStack = new boolean[cur];
        for(int i = 0; i < cur; i++) {
        	if(!visited[i] && map.containsKey(i))
        		dfs(i, groupGraph, visited, onStack, l);
        	if(hasCycle) return new int[] {};
        }
        
        int[] res = new int[n];
        int idx = 0;
        visited = new boolean[n];
        onStack = new boolean[n];
        for(int g : l) {
        	HashSet<Integer> items = map.get(g);
        	LinkedList<Integer> list = new LinkedList<>();
        	for(int i : items) {
        		if(!visited[i])
        			dfs(i, beforeItems, visited, onStack, list, items);
        		if(hasCycle) return new int[] {};
        	}
        	
        	for(int i : list) res[idx++] = i;
        }
        
        return res;
    }
	
	private void dfs(int i, List<List<Integer>> g, boolean[] visited, boolean[] onStack, LinkedList<Integer> l, HashSet<Integer> items) {
		visited[i] = true;
		onStack[i] = true;
		
		List<Integer> adj = g.get(i);
		for(int j : adj) {
			if(onStack[j]) {
				hasCycle = true;
				return;
			}
			
			if(!visited[j] && items.contains(j)) dfs(j, g, visited, onStack, l, items);
		}
		l.add(i);
		onStack[i] = false;
	}
	
	private void dfs(int i, ArrayList<ArrayList<Integer>> g, boolean[] visited, boolean[] onStack, LinkedList<Integer> l) {
		visited[i] = true;
		onStack[i] = true;
		
		ArrayList<Integer> adj = g.get(i);
		for(int j : adj) {
			if(onStack[j]) {
				hasCycle = true;
				return;
			}
			
			if(!visited[j]) dfs(j, g, visited, onStack, l);
		}
		
		l.add(i);
		onStack[i] = false;
	}
	
	public static void main(String[] args) {
		SortItemsbyGroupsRespectingDependencies test = new SortItemsbyGroupsRespectingDependencies();
		int[] group = {2,0,-1,3,0};
		List<List<Integer>> beforeItems = Arrays.asList(Arrays.asList(2,1,3), Arrays.asList(2,4), Arrays.asList(), Arrays.asList(), Arrays.asList());
		int[] res = test.sortItems(5, 5, group, beforeItems);
		
		System.out.println("");
	}
	
}
