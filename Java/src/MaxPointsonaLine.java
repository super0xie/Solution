import java.util.ArrayList;
import java.util.HashMap;

public class MaxPointsonaLine{

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    
    class PointHash {
        int x;
        int y;
        String hash;
        PointHash(Point p){
            this.x = p.x;
            this.y = p.y;
            this.hash = "" + x + "/" + y;
        }
    }

    public int maxPoints(Point[] points) {
        int res = 0;

        HashMap<String, Integer> p = new HashMap<>();
        ArrayList<PointHash> list = new ArrayList<>();
        for(Point point : points){
            String encode = "" + point.x + "/" + point.y;
            if(p.containsKey(encode)) p.put(encode, p.get(encode)+1);
            else {
                p.put(encode, 1);
                list.add(new PointHash(point));
            }
        }

        for(int i = 0; i < list.size(); i++){
            res = Math.max(res, p.get(list.get(i).hash));
            HashMap<String, Integer> map = new HashMap<>();
            int ix = list.get(i).x;
            int iy = list.get(i).y;

            for(int j = i + 1; j < list.size(); j++){
                int jx = list.get(j).x;
                int jy = list.get(j).y;
                int dy = jy-iy;
                int dx = jx-ix;
                
                String slope = null;
                if(dx == 0) slope = "Inf";
                else if(dy == 0) slope = "0";
                else {
                    int absx = Math.abs(dx);
                    int absy = Math.abs(dy);
                    int gcd = 0;
                    if(absy >= absx) gcd = gcd(absy, absx);
                    else gcd = gcd(absx, absy);
                    dy = dy / gcd;
                    dx = dx / gcd;
                    
                    int absdx = Math.abs(dx);
                    int absdy = Math.abs(dy);
                    
                    if((dy > 0 && dx > 0) || (dy < 0 && dx < 0)) {
                        slope = "" + absdy + "/" + absdx;
                    }else {
                        slope = "-" + absdy + "/" + absdx;
                    }
                    
                }

                int count = map.getOrDefault(slope, p.get(list.get(i).hash))+p.get(list.get(j).hash);
                res = Math.max(res, count);
                map.put(slope, count);
            }

        }
        return res;
    }
    
    private int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        MaxPointsonaLine test = new MaxPointsonaLine();
        Point[] points = new Point[]{test.new Point(0,0), test.new Point(94911151,94911150), test.new Point(94911152,94911151)};
        System.out.println(test.maxPoints(points));
    }

}