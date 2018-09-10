import java.util.HashSet;

public class WaterandJugProblem {
	private int x;
	private int y;
	private int z;
	public boolean canMeasureWaterSOF(int x, int y, int z) {
		if(z == 0) return true;
        this.x = x;
        this.y = y;
        this.z = z;
        
        HashSet<String> visited = new HashSet<String>();
        return dfs(0, 0, visited);
        
    }
	
	private boolean dfs(int a, int b, HashSet<String> visited) {
		visited.add(a+","+b);
		
		if(a == z || b == z) return true;
		
		int auxA;
		int auxB;
		if(a < x) {
			//b->a
			auxA = a + Math.min(x-a, b);
			auxB = b - Math.min(x-a, b);
			if(!visited.contains(auxA+","+auxB)) {
				if(dfs(auxA, auxB, visited)) return true;
			}
			
		}
		
		
		if(b < y) {
			//a->b
			auxA = a - Math.min(y-b, a);
			auxB = b + Math.min(y-b, a);
			if(!visited.contains(auxA+","+auxB)) {
				if(dfs(auxA, auxB, visited)) return true;
			}
		}
		
		if(!visited.contains(x+","+b) && dfs(x, b, visited)) return true;
		if(!visited.contains(a+","+y) && dfs(a, y, visited)) return true;
		if(!visited.contains(0+","+b) && dfs(0, b, visited)) return true;
		if(!visited.contains(a+","+0) && dfs(a, 0, visited)) return true;
		
		
		return false;
	}
	
	public boolean canMeasureWater(int x, int y, int z) {
		if(z == 0) return true;
        if(x + y < z) return false;
        
        return z % gcd(x, y) == 0;
    }
	
	private int gcd(int x, int y) {
		if(y == 0) return x;
		else return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		WaterandJugProblem test = new WaterandJugProblem();
		System.out.println(test.canMeasureWater(22003,31237,1));
	}

}
