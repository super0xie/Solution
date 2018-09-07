import java.util.Arrays;

public class FindRightInterval {
    private class IntervalWithIndex{
        Interval inter;
        int index;
        
        IntervalWithIndex(Interval inter, int index){
            this.inter = inter;
            this.index = index;
        }
    }
    
    public int[] findRightInterval(Interval[] intervals) {
        
        IntervalWithIndex[] arr = new IntervalWithIndex[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            arr[i] = new IntervalWithIndex(intervals[i], i);
        }
        Arrays.sort(arr, (a,b)->{return a.inter.start - b.inter.start;});
        int [] res = new int[intervals.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j].inter.start >= arr[i].inter.end) {
                    res[arr[i].index] = arr[j].index;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Interval[] intervals = {};
        FindRightInterval test = new FindRightInterval();
        test.findRightInterval(intervals);
    }

}
