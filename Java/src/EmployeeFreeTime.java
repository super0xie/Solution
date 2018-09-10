import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class EmployeeFreeTime {
	
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(List<Interval> list : schedule) {
        	for(Interval inter : list) {
        		map.put(inter.start, map.getOrDefault(inter.start, 0)+1);
        		map.put(inter.end, map.getOrDefault(inter.end, 0)-1);
        	}
        }
        
        List<Interval> res = new ArrayList<Interval>();
        int cur = 0;
        Interval inter = null;
        for(int i : map.keySet()) {
        	//end of inter
        	if(cur == 0 && map.get(i) > 0) {
        		if(inter != null) {
        			inter.end = i;
        			res.add(inter);
        		}
        	}
        	//start of inter
        	if(cur > 0 && cur+map.get(i) == 0) {
        		inter = new Interval();
        		inter.start = i;
        	}
        	cur += map.get(i);
        }
        
        return res;
    }

}
