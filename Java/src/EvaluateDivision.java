import java.util.HashMap;
import java.util.HashSet;

public class EvaluateDivision {
	
	HashMap<String, HashMap<String, Double>> graph;
	HashSet<String> visited;
	

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        graph = new HashMap<String, HashMap<String, Double>>();
        
        for(int i = 0; i < equations.length; i++) {
        	String a = equations[i][0];
        	String b = equations[i][1];
        	
        	HashMap<String, Double> map = null;
        	if(graph.containsKey(a)) {
        		map = graph.get(a);
        	}else {
        		map = new HashMap<String, Double>();
        		graph.put(a, map);
        	}
        	
        	map.put(b, values[i]);
        	
        	if(graph.containsKey(b)) {
        		map = graph.get(b);
        	}else {
        		map = new HashMap<String, Double>();
        		graph.put(b, map);
        	}
        	
        	map.put(a, 1 / values[i]);
        }

        double[] result = new double[queries.length];
        
        
        for(int i = 0; i < queries.length; i++) {
        	String a = queries[i][0];
        	String b = queries[i][1];
        	
        	if(!graph.containsKey(a) || !graph.containsKey(b)) {
        		result[i] = -1;
        		continue;
        	}
        	
        	if(a.equals(b)) {
        		result[i] = 1;
        		continue;
        	}
        	
        	
        	
        	visited = new HashSet<String>();
        	double r = dfs(a, b);
        	result[i] = r;

        }
        

        return result;
    }
	
	
	private double dfs(String a, String b) {
		if(visited.contains(a)) return -1.0;
		
		visited.add(a);
		if(graph.get(a).containsKey(b))
			return graph.get(a).get(b);
		
		for(String key : graph.get(a).keySet()) {
			double r = dfs(key, b);
			if(r > 0) return r * graph.get(a).get(key);
		}
		
		return -1.0;

	}
	
	public static void main(String[] args) {
		EvaluateDivision test = new EvaluateDivision();
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
		
		double[] result = test.calcEquation(equations, values, queries);
		System.out.println("hello");
	}
}
