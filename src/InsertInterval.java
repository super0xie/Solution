import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	
    	int index = 0;
    	for(Interval inter: intervals) {
    		if(inter.start > newInterval.start)
    			break;
    		else
    			index++;
    	}
    	
    	if(index == intervals.size()) {
    		intervals.add(newInterval);
    	}else {
    		intervals.add(index, newInterval);
    	}
    	
    	Interval last = null;
    	
    	
    	for(Interval inter: intervals) {
    		if(last == null) {
    			result.add(inter);
    			last = inter;
    			continue;
    		}
    		
    		if(inter.start <= last.end) {
    			last.end = Math.max(last.end, inter.end);
    		}else {
    			result.add(inter);
    			last = inter;
    		}
    			
    	}
    	
    	return result;

    }
    
}
