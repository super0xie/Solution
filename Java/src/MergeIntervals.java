import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start > o2.start) return 1;
                else if (o1.start < o2.start) return -1;
                return 0;
            }
        });
        
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        Interval last = null;
        for(Interval interval: intervals) {
            if(last == null) {
                last = new Interval(interval.start, interval.end);
                result.add(last);
                continue;
            }
            
            if(last.end >= interval.start) {
                if(last.end < interval.end) last.end = interval.end;
            }else {
                last = new Interval(interval.start, interval.end);
                result.add(last);
            }
        }
        
        return result;
    }

}
