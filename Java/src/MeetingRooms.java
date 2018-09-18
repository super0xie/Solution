import java.util.Arrays;
import java.util.TreeMap;

public class MeetingRooms {
	
	public boolean canAttendMeetingsSort(Interval[] intervals) {
        Arrays.sort(intervals, (a,b)->{return a.start - b.start;});
        for(int i = 1; i < intervals.length; i++) {
        	if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
	
	public boolean canAttendMeetingsPM(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for(Interval inter : intervals) {
        	map.put(inter.start, map.getOrDefault(inter.start, 0)+1);
        	map.put(inter.end, map.getOrDefault(inter.end, 0)-1);
        }
        
        int sum = 0;
        for(int key : map.keySet()) {
        	sum += map.get(key);
        	if(sum > 1) return false;
        }
        
        return true;
    }

}
