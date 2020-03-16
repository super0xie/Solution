import java.util.ArrayList;

public class DeleteTreeNodes {
	
	
	
	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
		ArrayList<Integer>[] g = new ArrayList[nodes];
		for(int i = 0; i < nodes; i++) {
			if(parent[i] >= 0) {
				if(g[parent[i]] == null) g[parent[i]] = new ArrayList<>();
				g[parent[i]].add(i);
			}
		}
		
		boolean[] remove = new boolean[nodes];
		
		dfs(0, g, value, remove);
		dfs(0, remove, false, g);
		int res = 0;
		for(boolean b : remove) {
			if(!b) res++;
		}
		
		return res;
    }
	
	private int dfs(int i, ArrayList<Integer>[] g, int[] value, boolean[] remove) {
		int sum = value[i];
		
		if(g[i] != null) {
			for(int child : g[i]) {
				sum += dfs(child, g, value, remove);
			}
		}
		
		if(sum == 0) remove[i] = true;
		
		return sum;
	}
	
	private void dfs(int i, boolean[] remove, boolean toRemove, ArrayList<Integer>[] g) {
		boolean r = remove[i] || toRemove;
		remove[i] = r;
		
		if(g[i] != null) {
			for(int child : g[i]) {
				dfs(child, remove, r, g);
			}
		}
	}
	
	public static void main(String[] args) {
		DeleteTreeNodes test = new DeleteTreeNodes();
		System.out.println(test.deleteTreeNodes(7, new int[]{-1,0,0,1,2,2,2}, new int[] {1,-2,4,0,-2,-1,-1}));
	}
	
	
	
}
