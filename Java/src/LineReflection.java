import java.util.HashMap;
import java.util.HashSet;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        for(int i = 0; i < points.length; i++) {
            if(map.containsKey(points[i][1])) {
                map.get(points[i][1]).add(points[i][0]);
            }else {
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(points[i][0]);
                map.put(points[i][1], set);
            }
        }
        
        double axis = Double.MIN_VALUE;
        for(int i : map.keySet()) {
            HashSet<Integer> set = map.get(i);
            int sum = 0;
            for(int j : set) {
                sum += j;
            }
            double avg = (double)sum / set.size();
            
            if(axis != Double.MIN_VALUE) {
                if(avg != axis) return false;
            }
            
            for(int j : set) {
                if(!set.contains((int)(2 * avg) - j)) return false;
            }
            axis = avg;
            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        LineReflection test = new LineReflection();
        int[][] points = {{0,0}, {1,0}};
        System.out.println(test.isReflected(points));
        
    }

}
