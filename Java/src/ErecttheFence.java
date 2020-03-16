import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErecttheFence {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    class PointWithCos implements Comparable<PointWithCos>{
        Point p;
        double cos;
        int dis;

        @Override
        public int compareTo(PointWithCos o) {
            double res = o.cos - this.cos;
            if(res > 0) return 1;
            else if(res == 0) return this.dis - o.dis;
            else return -1;
        }
    }

    public List<Point> outerTrees(Point[] points) {
        ArrayList<Point> res = new ArrayList<>();

        Point low = points[0];
        for(int i = 1; i < points.length; i++){
            if(points[i].y < low.y) low = points[i];
            else if(points[i].y == low.y && points[i].x < low.y){
                low = points[i];
            }
        }

        PointWithCos[] pWithCos = new PointWithCos[points.length];
        for(int i = 0; i < points.length; i++){
            PointWithCos pwc = new PointWithCos();
            pwc.p = points[i];
            if(points[i] == low){
                pwc.cos = 2;
            }else{
                int dx = pwc.p.x - low.x;
                int dy = pwc.p.y - low.y;
                pwc.dis = dx * dx + dy * dy;
                pwc.cos = dx * dx / (double)pwc.dis;
                if(dx < 0) pwc.cos = -pwc.cos;
            }
            pWithCos[i] = pwc;
        }

        Arrays.sort(pWithCos);

        res.add(low);
        ArrayList<Point> skipped = new ArrayList<>();
        for(int i = 1; i < pWithCos.length; i++){
            if(i != pWithCos.length-1 && pWithCos[i].cos == pWithCos[pWithCos.length-1].cos) {
                skipped.add(pWithCos[i].p);
                continue;
            }
            while(res.size() >= 2 && !ccw(res.get(res.size()-2), res.get(res.size()-1), pWithCos[i].p)){
                res.remove(res.size()-1);
            }
            res.add(pWithCos[i].p);
        }
        res.addAll(skipped);
        return res;
    }

    private boolean ccw(Point a, Point b, Point c){
        double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if(area >= 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] p = {{1,2},{2,2},{4,2}};
        Point[] points = new Point[p.length];
        ErecttheFence test = new ErecttheFence();
        for(int i = 0; i < p.length; i++){
            points[i] = test.new Point(p[i][0], p[i][1]);
        }

        List<Point> res = test.outerTrees(points);

        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i).x + ", " + res.get(i).y);
        }

    }

}