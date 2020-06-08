import java.util.ArrayList;
import java.util.HashMap;

public class CherryPickupII {
	
//	public int cherryPickup(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(n-1, grid[0][0]+grid[0][n-1]);
//        for(int r = 1; r < m; r++) {
//        	HashMap<Integer, Integer> aux = new HashMap<>();
//        	for(int key : map.keySet()) {
//        		int a = key / 100;
//        		int b = key % 100;
//        		int v = map.get(key);
//        		for(int i = a-1; i <= a+1; i++) {
//        			for(int j = b-1; j <= b+1; j++) {
//        				if(i < 0 || i >= n || j < 0 || j >= n) continue;
//        				int cur = v;
//        				if(i == j) {
//        					cur += grid[r][i];
//        				}else {
//        					cur += grid[r][i] + grid[r][j];
//        				}
//        				aux.put(100 * i + j, Math.max(aux.getOrDefault(100 * i + j, 0), cur));
//        			}
//        		}
//        	}
//        	
//        	map = aux;
//        }
//        
//        int res = 0;
//        for(int key : map.keySet()) res = Math.max(map.get(key), res);
//        return res;
//    }
	
	public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sz = (n-1)*n + n;
        
        ArrayList<Integer> l = new ArrayList<>();
        l.add(n-1);
        int[] cache = new int[sz];
        cache[n-1] = grid[0][0]+grid[0][n-1];
        
        for(int r = 1; r < m; r++) {
        	int[] auxCache = new int[sz];
        	ArrayList<Integer> auxl = new ArrayList<>();
        	HashMap<Integer, Integer> aux = new HashMap<>();
        	for(int key : l) {
        		int a = key / n;
        		int b = key % n;
        		int v = cache[key];
        		for(int i = a-1; i <= a+1; i++) {
        			for(int j = b-1; j <= b+1; j++) {
        				if(i < 0 || i >= n || j < 0 || j >= n) continue;
        				int cur = v;
        				if(i == j) {
        					cur += grid[r][i];
        				}else {
        					cur += grid[r][i] + grid[r][j];
        				}
        				int encode = n*i+j;
        				if(auxCache[encode] == 0) auxl.add(encode);
        				auxCache[encode] = Math.max(auxCache[encode], cur);
        			}
        		}
        	}
        	
        	cache = auxCache;
        	l = auxl;
        }
        
        int res = 0;
        for(int key : l) res = Math.max(cache[key], res);
        return res;
    }
	
}
