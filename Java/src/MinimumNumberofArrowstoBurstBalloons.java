import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class MinimumNumberofArrowstoBurstBalloons {
    
    public int findMinArrowShotsOld(int[][] points) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, ArrayList<Integer>> endsMap = new HashMap<>();
        int res = 0;
        for(int[] p : points) {
            map.put(p[0], map.getOrDefault(p[0], 0));
            map.put(p[1], map.getOrDefault(p[1], 0)+1);
            
            if(endsMap.containsKey(p[0])) {
                endsMap.get(p[0]).add(p[1]);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(p[1]);
                endsMap.put(p[0], l);
            }
        }
        
        ArrayList<Integer> starts = new ArrayList<>();
        for(int i : map.keySet()) {
            if(endsMap.containsKey(i)) {
                starts.add(i);
            }
            
            if(map.get(i) > 0) {
                if(!starts.isEmpty()) {
                    res++;
                    for(int s : starts) {
                        ArrayList<Integer> ends = endsMap.get(s);
                        for(int e : ends) {
                            map.put(e, map.get(e)-1);
                        }
                    }
                    starts.clear();
                }
            }
            
        }
        
        
        return res;
    }
    
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {return a[0]-b[0];});
        int[] last = points[0];
        int res = 1;
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= last[1]) {
                last[1] = Math.min(last[1], points[i][1]);
            }else {
                res++;
                last = points[i];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons test = new MinimumNumberofArrowstoBurstBalloons();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(test.findMinArrowShots(points));
    }
    
}
