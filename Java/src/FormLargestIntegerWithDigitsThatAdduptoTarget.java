import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FormLargestIntegerWithDigitsThatAdduptoTarget {
	
	class N{
		int c;
		char s;
		
		N(int cost, String str){
			c = cost;
			s = str.charAt(0);
		}
	}
	
	//dp
	public String largestNumberDP(int[] cost, int target) {
		
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < cost.length; i++) {
        	if(cost[i] <= target) {
        		if(map.containsKey(cost[i])) {
        			String s = map.get(cost[i]);
        			String cur = String.valueOf(i+1);
        			map.put(cost[i], s.compareTo(cur) >= 0 ? s : cur);
        		}else {
        			map.put(cost[i], String.valueOf(i+1));
        		}
        	}
        }
        String res = "0";
        
        N[] costs = new N[map.size()];
        int idx = 0;
        for(int key : map.keySet())
        	costs[idx++] = new N(key, map.get(key));
        
        Arrays.sort(costs, (a, b)->{
        	return b.s-a.s;
        });
        
        while(!map.isEmpty()) {
        	if(map.containsKey(target)) res = map.get(target);
        	
        	HashMap<Integer, String> aux = new HashMap<>();
        	for(int c : map.keySet()) {
        		
        		for(int i = 0; i < costs.length; i++) {
        			int ncost = c+costs[i].c;
        			if(ncost > target) continue;
        			
        			
        			if(aux.containsKey(ncost)) {
        				String e = aux.get(ncost);
        				if(e.charAt(0) > costs[i].s) continue;
        				else {
        					String newString = costs[i].s + map.get(c);
        					if(e.charAt(0) < costs[i].s) {
        						aux.put(ncost, newString);
        					}else {
        						aux.put(ncost, aux.get(ncost).compareTo(newString) >= 0 ? aux.get(ncost) : newString);
        					}
        				}
        			}else {
        				String newString = costs[i].s + map.get(c);
        				aux.put(ncost, newString);
        			}
        		}
        	}
        	
        	map = aux;
        }
        
        return res;
    }
	
	//dfs
	public String largestNumber(int[] cost, int target) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < cost.length; i++) {
        	if(cost[i] <= target) {
        		if(map.containsKey(cost[i])) {
        			String s = map.get(cost[i]);
        			String cur = String.valueOf(i+1);
        			map.put(cost[i], s.compareTo(cur) >= 0 ? s : cur);
        		}else {
        			map.put(cost[i], String.valueOf(i+1));
        		}
        	}
        }
        
        
        N[] costs = new N[map.size()];
        int idx = 0;
        for(int key : map.keySet())
        	costs[idx++] = new N(key, map.get(key));
        
        Arrays.sort(costs, (a, b)->{
        	return b.s-a.s;
        });
        
        HashMap<Integer, String> cache = new HashMap<>();
        
        String res = dfs(target, costs, cache);
        
        return res;
    }
	
	private String dfs(int c, N[] costs, HashMap<Integer, String> cache) {
		if(cache.containsKey(c)) return cache.get(c);
		
		String res = "0";
		for(N n : costs) {
			int remain = c - n.c;
			if(remain > 0) {
				String ret = dfs(remain, costs, cache);
				if(!ret.equals("0"))
					res = max(res, n.s + ret);
			} else if(remain == 0) {
				res = max(res, "" + n.s);
			}
		}
		
		cache.put(c, res);
		
		
		return res;
	}
	
	private String max(String s1, String s2) {
		int res = compare(s1, s2);
		if(res >= 0) return s1;
		else return s2;
	}
	
	private int compare(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return s1.length()-s2.length();
		}else {
			return s1.compareTo(s2);
		}
	}
	
	public static void main(String[] args) {
		FormLargestIntegerWithDigitsThatAdduptoTarget test = new FormLargestIntegerWithDigitsThatAdduptoTarget();
		System.out.println(test.largestNumber(new int[] {4,3,2,5,6,7,2,5,5}, 9));
	}
	
}
