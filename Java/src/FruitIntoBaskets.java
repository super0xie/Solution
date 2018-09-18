import java.util.HashMap;

public class FruitIntoBaskets {
	
	public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < tree.length; i++) {
        	map.put(tree[i], map.getOrDefault(tree[i], 0)+1);
        	while(map.size() > 2) {
        		int cur = map.get(tree[start]);
        		if(cur > 1) {
        			map.put(tree[start], cur-1);
        		}else {
        			map.remove(tree[start]);
        		}
        		
        		start++;
        	}
        	
        	res = Math.max(res, i-start+1);
        }
        
        return res;
        
    }

}
