import java.util.HashMap;

public class SoupServings {
	
	HashMap<String, Double> mem;
	public double soupServings(int N) {
		if(N > 6000) return 1;
        mem = new HashMap<String, Double>();
        return dfs(N, N);
    }
	
	private double dfs(int a, int b) {
		String key = a + "," + b;
		if(mem.containsKey(key)) return mem.get(key);
		
		if(a <= 0 || b <= 0) {
			if(a <= 0 && b <= 0) return 0.5;
			if(a <= 0) return 1;
			if(b <= 0) return 0;
		}
		
		double res = 0.25 * (dfs(a-100, b) + dfs(a-75, b-25) + dfs(a-50, b-50) + dfs(a-25, b-75));
		
		mem.put(key, res);
		return res;
	}
	
	public static void main(String[] args) {
		SoupServings test = new SoupServings();
		System.out.println(test.soupServings(6000));
	}
	
}
