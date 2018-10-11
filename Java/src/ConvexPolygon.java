import java.util.List;

public class ConvexPolygon {
    
    public boolean isConvex(List<List<Integer>> points) {
        
        int dir = Integer.MAX_VALUE;
        for(int i = 2; i < points.size(); i++) {
            int[] vector1 = {points.get(i-1).get(0)-points.get(i-2).get(0), points.get(i-1).get(1)-points.get(i-2).get(1)};
            int[] vector2 = {points.get(i).get(0)-points.get(i-1).get(0), points.get(i).get(1)-points.get(i-1).get(1)};
            
            int crossProduct = vector1[0]*vector2[1] - vector1[1]*vector2[0];
            if(dir == Integer.MAX_VALUE) {
                if(crossProduct > 0) dir = 1;
                else if(crossProduct < 0) dir = -1;
            } else {
                if(crossProduct * dir < 0) return false;
            }
        }
        
        int[] vector1 = {points.get(points.size()-1).get(0)-points.get(points.size()-2).get(0), 
                points.get(points.size()-1).get(1)-points.get(points.size()-2).get(1)};
        int[] vector2 = {points.get(0).get(0)-points.get(points.size()-1).get(0), points.get(0).get(1)-points.get(points.size()-1).get(1)};
        int crossProduct = vector1[0]*vector2[1] - vector1[1]*vector2[0];
        if(crossProduct * dir < 0) return false;
        
        
        vector1 = vector2;
        vector2 = new int [] {points.get(1).get(0)-points.get(0).get(0), points.get(1).get(1)-points.get(0).get(1)};
        crossProduct = vector1[0]*vector2[1] - vector1[1]*vector2[0];
        if(crossProduct * dir < 0) return false;
        
        return true;
    }
    
}
