import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MaximumNumberofEventsThatCanBeAttended {

    
    
    public int maxEventsOld(int[][] events) {
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 0; i < events.length; i++) {
            if(!map.containsKey(events[i][0])) map.put(events[i][0], new ArrayList<>());
            map.get(events[i][0]).add(events[i][1]);
        }
        
        int start = map.firstKey();
        int res = 0;
        while(true) {
            if(map.containsKey(start)) {
                ArrayList<Integer> ends = map.get(start);
                res++;
                if(ends.size() > 1) {
                    Collections.sort(ends);
                    ArrayList<Integer> next = null;
                    if(map.containsKey(start+1)) next = map.get(start+1);
                    else next = new ArrayList<>();
                    
                    for(int i = 1; i < ends.size(); i++) {
                        if(ends.get(i) >= start + 1) next.add(ends.get(i));
                    }
                    
                    if(next.isEmpty()) {
                        Integer ret = map.ceilingKey(start + 1);
                        if(ret == null) break;
                        start = ret;
                    } else {
                        map.put(start+1, next);
                        start = start + 1;
                    }
                }else {
                    Integer ret = map.ceilingKey(start + 1);
                    if(ret == null) break;
                    start = ret;
                }
                
            }else {
                break;
            }
            
        }
        
        return res;
    }
    
    public int maxEvents(int[][] events) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 0; i < events.length; i++) {
            if(!map.containsKey(events[i][0])) map.put(events[i][0], new ArrayList<>());
            map.get(events[i][0]).add(events[i][1]);
        }
        
        int start = map.firstKey();
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(true) {
            if(map.containsKey(start)) {
                ArrayList<Integer> ends = map.get(start);
                for(int i : ends) pq.add(i);
            }
            
            while(!pq.isEmpty()) {
                int poll = pq.poll();
                if(poll >= start) { 
                    res++;
                    break;
                }
            }
            
            if(pq.isEmpty()) {
                Integer ret = map.ceilingKey(start + 1);
                if(ret == null) break;
                start = ret;
            }else {
                start = start + 1;
            }
            
        }
        
        return res;
    }
    
    
    public static void main(String[] args) {
        MaximumNumberofEventsThatCanBeAttended test = new MaximumNumberofEventsThatCanBeAttended();
        int[][] events = {{1,2},{2,3},{3,4}};
        System.out.println(test.maxEvents(events));
        
        
    }
    
}
