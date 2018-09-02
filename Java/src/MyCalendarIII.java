
import java.util.TreeMap;

public class MyCalendarIII {
	TreeMap<Integer, Integer> map;
	
	public void MyCalendarThree() {
		map = new TreeMap<Integer, Integer>();
		
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        
        int res = 0;
        int count = 0;
        for(int v : map.values()) {
        	count += v;
        	res = Math.max(res, count);
        }
        
        return res;
    }

}
