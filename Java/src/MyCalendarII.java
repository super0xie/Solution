import java.util.TreeMap;


public class MyCalendarII {
	
	
	TreeMap<Integer, Integer> list;
	
    public void MyCalendarTwo() {
    	list = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
    	list.put(start, list.getOrDefault(start, 0)+1);
    	list.put(end, list.getOrDefault(end, 0)-1);
    	
    	int curr = 0;
    	
    	for(int i : list.values()) {
    		curr = curr + i;
    		if(curr >= 3) {
    			list.put(start, list.get(start)-1);
    	    	list.put(end, list.get(end)+1);
    			return false;
    		}
    	}
    	return true;
    	
    }

}
