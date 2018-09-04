import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberofBoomerangs {
    
    public int numberOfBoomerangs(int[][] points) {
        int[][] dis = new int [points.length][points.length];
        int result = 0;
        
        for(int i = 0; i < points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                dis[i][j] = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                dis[j][i] = dis[i][j];
            }
        }
        
        for(int i = 0; i < points.length; i++) {
            HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
            for(int j = 0; j < points.length; j++) {
                if(map.containsKey(dis[i][j])) {
                    map.get(dis[i][j]).add(points[j]);
                }else {
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(points[j]);
                    map.put(dis[i][j], list);
                }
            }
            
            for(int key: map.keySet()) {
                int size = map.get(key).size();
                if(size > 1) {
                    result += size * (size-1);
                }
            }
        }
        return result;
    }

}
