import java.util.ArrayList;

public class CourseSchedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//build graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++) {
        	graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < prerequisites.length; i++) {
        	graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean [] visited = new boolean [numCourses];
        boolean [] onStack = new boolean [numCourses];
        
        for(int i = 0; i < numCourses; i++) {
        	if(dfs(i, visited, onStack, graph)) return false;
        }
        
        return true;
        
    }
	
	private boolean dfs(int node, boolean[] visited, boolean[] onStack, ArrayList<ArrayList<Integer>> graph) {
		if(onStack[node]) return true;
		if(visited[node]) return false;
		
		
		visited[node] = true;
		onStack[node] = true;
		boolean result = false;
		for(int i : graph.get(node)) {
			result = result || dfs(i, visited, onStack, graph);
		}
		
		if(result) return true;
		
		onStack[node] = false;
		return false;
	}
	
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites = {{0,1}, {1,0}};
		System.out.println(cs.canFinish(2, prerequisites));
		
		int[][] prerequisites2 = {{0,1}, {1,2}, {0,2}};
		System.out.println(cs.canFinish(3, prerequisites2));
	}

}
