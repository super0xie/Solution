import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TimeBasedKeyValueStore {
	
	class Ent {
		ArrayList<String> v;
		ArrayList<Integer> t;
		
		Ent(){
			v = new ArrayList<>();
			t = new ArrayList<>();
		}
	}
	
	private HashMap<String, Ent> map;
	
	
    public void TimeMap() {
    	map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
        	Ent e = map.get(key);
        	e.v.add(value);
        	e.t.add(timestamp);
        }else {
        	Ent e = new Ent();
        	e.v.add(value);
        	e.t.add(timestamp);
        	map.put(key, e);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
        	Ent e = map.get(key);
        	int s = Collections.binarySearch(e.t, timestamp);
        	if(s >= 0) {
        		return e.v.get(s);
        	}else {
        		int ip = -s-1;
        		if(ip == 0) return "";
        		else return e.v.get(ip-1);
        	}
        }else {
        	return "";
        }
    }
}
