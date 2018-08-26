import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MeetingRoomsII {
	
	public int minMeetingRooms(Interval[] intervals) {
		int result = 0;
		int maxResult = 0;
        LinkedList<Interval> currentInterval = new LinkedList<Interval>();
        Arrays.sort(intervals, (Interval i1, Interval i2)->{
        	return i1.start - i2.start;
        });
        
        for(int i = 0; i < intervals.length; i++) {
        	currentInterval.add(intervals[i]);
        	int start = intervals[i].start;
        	result++;
        	Iterator<Interval> iter = currentInterval.iterator();
        	while (iter.hasNext()) {
        	    if (iter.next().end <= start) {
        	        iter.remove();
        	        result--;
        	    }
        	}
        	
        	if(result > maxResult) maxResult = result;
        }
        
        
        
        
        return maxResult;
    }
	
	public static void main(String[] args) {
		MeetingRoomsII test = new MeetingRoomsII();
		Interval i1 = new Interval(13, 15);
		Interval i2 = new Interval(1, 13);
		Interval i3 = new Interval(6, 9);
		
		Interval[] in = {i1,i2,i3};
		test.minMeetingRooms(in);
		
	}
	
}
