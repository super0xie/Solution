import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        int counter = 1;
        
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        
        
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= end) {
                counter++;
                end = intervals[i].end;
            }
        }
        
        
        return intervals.length - counter;
    }

}
