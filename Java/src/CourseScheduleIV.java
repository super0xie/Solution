import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleIV {
	
//	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
//		ArrayList<Integer>[] g = new ArrayList[n];
//		HashSet<Integer>[] subCourse = new HashSet[n];
//		for(int i = 0; i < n; i++) {
//			g[i] = new ArrayList<>();
//			subCourse[i] = new HashSet<>();
//		}
//		
//        for(int[] p : prerequisites) {
//        	g[p[0]].add(p[1]);
//        }
//        
//        for(int i = 0; i < n; i++) {
//        	boolean[] visited = new boolean[n];
//        	dfs(i, visited, g);
//        	for(int j = 0; j < n; j++) {
//        		if(visited[j]) {
//        			subCourse[i].add(j);
//        		}
//        	}
//        }
//        
//        List<Boolean> res = new ArrayList<>();
//        for(int[] q : queries) {
//        	if(subCourse[q[0]].contains(q[1])) res.add(true);
//        	else res.add(false);
//        }
//        return res;
//    }
//	
//	private void dfs(int i, boolean[] visited, ArrayList<Integer>[] g) {
//		visited[i] = true;
//		for(int adj : g[i]) {
//			if(!visited[adj]) dfs(adj, visited, g);
//		}
//	}
	
	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		ArrayList<Integer>[] g = new ArrayList[n];
		HashSet<Integer>[] subCourse = new HashSet[n];
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
			subCourse[i] = new HashSet<>();
		}
		
        for(int[] p : prerequisites) {
        	g[p[0]].add(p[1]);
        }
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
        	if(visited[i]) continue;
        	dfs(i, visited, g, subCourse);
        }
        
        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries) {
        	if(subCourse[q[0]].contains(q[1])) res.add(true);
        	else res.add(false);
        }
        return res;
    }
	
	private void dfs(int i, boolean[] visited, ArrayList<Integer>[] g, HashSet<Integer>[] subCourse) {
		visited[i] = true;
		for(int adj : g[i]) {
			if(!visited[adj]) dfs(adj, visited, g, subCourse);
			subCourse[i].addAll(subCourse[adj]);
		}
		subCourse[i].add(i);
	}
	
	public static void main(String[] args) {
		CourseScheduleIV test = new CourseScheduleIV();
		int[][] prerequisites = {{1, 0}};
		int[][] queries = {{0,1}, {1, 0}};
		test.checkIfPrerequisite(2, prerequisites, queries);
	}
	
	
	
}
