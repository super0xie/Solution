import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class MinimumAreaRectangle {
	
	public int minAreaRect(int[][] points) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        for(int[] point : points) {
        	int x = point[0];
        	int y = point[1];
        	if(map.containsKey(y)) map.get(y).add(x);
        	else {
        		ArrayList<Integer> list = new ArrayList<>();
        		list.add(x);
        		map.put(y, list);
        	}
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int y : map.keySet()) {
        	ArrayList<Integer> list = map.get(y);
        	Collections.sort(list);
        	for(int i = 0; i < list.size(); i++) {
        		for(int j = i+1; j < list.size(); j++) {
        			int encode = 40000 * list.get(i) + list.get(j);
        			if(hmap.containsKey(encode)) {
        				int area = (list.get(j)-list.get(i)) * (y-hmap.get(encode));
        				res = Math.min(res, area);
        			}
        			hmap.put(encode, y);
        		}
        	}
        }
        if(res == Integer.MAX_VALUE) return 0;
        else return res;
    }
	
	public static void main(String[] args) {
		MinimumAreaRectangle test = new MinimumAreaRectangle();
		int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
		System.out.println(test.minAreaRect(points));
	}
}
