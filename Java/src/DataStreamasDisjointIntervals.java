import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class DataStreamasDisjointIntervals {

    HashSet<Integer> set;
    TreeMap<Integer, Interval> lmap;
    TreeMap<Integer, Interval> rmap;


    public void SummaryRanges() {
        set = new HashSet<>();
        lmap = new TreeMap<>();
        rmap = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(set.contains(val)) return;
        set.add(val);

        if(lmap.containsKey(val+1) && rmap.containsKey(val-1)){
            Interval right = lmap.get(val+1);
            Interval left = rmap.get(val-1);
            lmap.remove(val+1);
            rmap.remove(val-1);

            Interval inter = new Interval(left.start, right.end);
            lmap.put(inter.start, inter);
            rmap.put(inter.end, inter);
        }else if(lmap.containsKey(val+1)){
            Interval inter = lmap.get(val+1);
            lmap.remove(val+1);
            inter.start = val;
            lmap.put(inter.start, inter);
        }else if(rmap.containsKey(val-1)){
            Interval inter = rmap.get(val-1);
            rmap.remove(val-1);
            inter.end = val;
            rmap.put(inter.end, inter);
        }else{
            Interval inter = new Interval(val, val);
            lmap.put(val, inter);
            rmap.put(val, inter);
        }
        
    }
    
    public List<Interval> getIntervals() {
        ArrayList<Interval> l = new ArrayList<>();
        for(int i : lmap.keySet()){
            l.add(lmap.get(i));
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 2, 6};
        DataStreamasDisjointIntervals test = new DataStreamasDisjointIntervals();
        test.SummaryRanges();
        for(int i : nums){
            test.addNum(i);
            List<Interval> l = test.getIntervals();
            for(Interval inter : l){
                System.out.print("[" + inter.start + ", " + inter.end + "], ");
            }
            System.out.println("");
        }
        

    }
}