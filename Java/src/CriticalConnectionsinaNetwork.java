import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CriticalConnectionsinaNetwork {
	
	public List<List<Integer>> criticalConnectionsTLE(int n, List<List<Integer>> connections) {
		List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> l : connections) {
        	graph[l.get(0)].add(l.get(1));
        	graph[l.get(1)].add(l.get(0));
        }
        
        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];
        
        ArrayList<Integer> stack = new ArrayList<>();
        HashSet<Integer> conInLoop = new HashSet<>();
        dfs(0, graph, visited, onStack, stack, conInLoop, -1);
        
        for(List<Integer> l : connections) {
        	int enc = encode(l.get(0), l.get(1));
        	if(!conInLoop.contains(enc)) res.add(l);
        }
        
        return res;
    }
	
	private void dfs(int i, ArrayList<Integer>[] graph, boolean[] visited, boolean[] onStack, ArrayList<Integer> stack, HashSet<Integer> conInLoop, int from) {
		visited[i] = true;
		onStack[i] = true;
		stack.add(i);
		
		for(int adj : graph[i]) {
			
			if(adj == from) continue;
			
			if(!visited[adj]) {
				dfs(adj, graph, visited, onStack, stack, conInLoop, i);
			}
			
			if(onStack[adj]) {
				conInLoop.add(encode(i, adj));
				for(int j = stack.size()-1; j >= 1; j--) {
					int encode = encode(stack.get(j), stack.get(j-1));
					conInLoop.add(encode);
					if(stack.get(j-1) == adj) {
						break;
					}
				}
			}
			
		}
		
		stack.remove(stack.size()-1);
		onStack[i] = false;
	}
	
	private int encode(int a, int b) {
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return a * 100000 + b;
	}
	
	
	
	
	private int cur = 1;
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> l : connections) {
        	graph[l.get(0)].add(l.get(1));
        	graph[l.get(1)].add(l.get(0));
        }
        
        int[] seq = new int[n];
        
        dfs(0, graph, seq, res, -1);
        
        
        return res;
    }
	
	private int dfs(int i, ArrayList<Integer>[] graph, int[] seq, List<List<Integer>> res, int from) {
		seq[i] = cur++;
		int min = Integer.MAX_VALUE;
		
		for(int adj : graph[i]) {
			
			if(adj == from) continue;
			
			if(seq[adj] == 0) {
				int ret = dfs(adj, graph, seq, res, i);
				if(ret > seq[i]) res.add(Arrays.asList(i, adj));
				min = Math.min(min, ret);
			}else {
				min = Math.min(min, seq[adj]);
			}
			
		}
		
		min = Math.min(min, seq[i]);
		return min;
	}
	

	
	
	
	
	public static void main(String[] args) {
		CriticalConnectionsinaNetwork test = new CriticalConnectionsinaNetwork();
//		List<List<Integer>> res = test.criticalConnections(5, Arrays.asList(Arrays.asList(1, 0), Arrays.asList(0, 2), Arrays.asList(2, 3), Arrays.asList(4, 2), Arrays.asList(4, 3), Arrays.asList(3, 0), Arrays.asList(4, 0)));
//		List<List<Integer>> res = test.criticalConnections(4, Arrays.asList(Arrays.asList(1, 0), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)));
		List<List<Integer>> connections = TestcaseFileReader.getListArrays();
		List<List<Integer>> res = test.criticalConnections(10000, connections);
		for(List<Integer> l : res)
			System.out.println(l.get(0) + " " +  l.get(1));
		
//		System.out.println("hello");
	}
	
}
