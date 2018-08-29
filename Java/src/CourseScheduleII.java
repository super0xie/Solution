import java.util.ArrayList;
import java.util.Stack;

public class CourseScheduleII {
	private boolean [] visited;
	private boolean [] onStack;
	private ArrayList<ArrayList<Integer>> graph;
	private Stack<Integer> stack;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int [numCourses];
        
        graph = new ArrayList<ArrayList<Integer>>();
        stack = new Stack<Integer>();
        for(int i = 0; i < numCourses; i++) {
        	graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
        	graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visited = new boolean [numCourses];
        onStack = new boolean [numCourses];
        
        
        for(int i = 0; i < numCourses; i++) {
        	if(dfs(i)) return new int [0];
        }
        
        int index = 0;
        while(!stack.isEmpty()) {
        	result[index++] = stack.pop();
        }
        
        
        
        return result;
    }
	
	//return if contain cycle
	private boolean dfs(int node) {
		if(onStack[node]) return true;
		if(visited[node]) return false;
		
		onStack[node] = true;
		visited[node] = true;
		
		for(int childNode : graph.get(node)) {
			if(dfs(childNode)) return true;
		}
		
		onStack[node] = false;
		
		stack.push(node);
		return false;
	}
}
