import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableofFoodOrdersinaRestaurant {
	
	public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        
        TreeMap<Integer, Integer> tables = new TreeMap<>();
        TreeMap<String, Integer> foods = new TreeMap<>();
        
        for(List<String> o : orders) {
        	tables.put(Integer.parseInt(o.get(1)), 0);
        	foods.put(o.get(2), 0);
        }
        
        int idx = 1;
        List<String> header = new ArrayList<>();
        header.add("Table");
        for(String key : foods.keySet()) {
        	foods.put(key, idx++);
        	header.add(key);
        }
        res.add(header);
        
        int[][] aux = new int[tables.size()+1][foods.size()+1];
        
        idx = 1;
        for(Integer key : tables.keySet()) {
        	tables.put(key, idx);
        	aux[idx][0] = key;
        	idx++;
        }
        
        for(List<String> o : orders) {
        	int i = tables.get(Integer.parseInt(o.get(1)));
        	int j = foods.get(o.get(2));
        	aux[i][j]++;
        }
        
        for(int i = 1; i < aux.length; i++) {
        	ArrayList<String> l = new ArrayList<>();
        	for(int j = 0; j < aux[0].length; j++) {
        		l.add(String.valueOf(aux[i][j]));
        	}
        	res.add(l);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
	
				
	}
}
