import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    
    private class Point{
        int x;
        int y;
        int d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
        
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b)->{return b.d-a.d;});
        
        for(int[] p : points) {
            int d = p[0]*p[0] + p[1]*p[1];
            if(pq.size() == K) {
                if(pq.peek().d > d) {
                    pq.poll();
                    pq.add(new Point(p[0], p[1], d));
                }
            }else {
                pq.add(new Point(p[0], p[1], d));
            }
        }
        
        int[][] res = new int[K][2];
        int idx = 0;
        
        for(Point p : pq) {
            res[idx][0] = p.x;
            res[idx][1] = p.y;
            idx++;
        }
        
        return res;
        
    }
}
