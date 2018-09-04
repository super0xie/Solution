import java.util.ArrayList;
import java.util.Collections;

public class MyCalendarI {
	
	private class Interval implements Comparable<Interval>{
		int start;
		int end;
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Interval other) {
			return this.start - other.start;
		}
	}
	
	ArrayList<Interval> list;
	
	public void MyCalendar() {
        list = new ArrayList<Interval>();
    }
	
	public boolean book(int start, int end) {
		Interval inter = new Interval(start, end);
        int result = Collections.binarySearch(list, inter, (a,b)->{
        	return a.start - b.start;
        });
        
        if(result >= 0) return false;
        else {
        	int insert = -result-1;
        	if(insert > 0) {
        		Interval pre = list.get(insert-1);
        		if(pre.end > inter.start) return false;
        	}
        	
        	if(insert < list.size()) {
        		Interval after = list.get(insert);
        		if(inter.end > after.start) return false;
        	}
        	
        	list.add(insert, inter);
        	return true;
        }
    }

}
