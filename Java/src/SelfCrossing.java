import java.util.ArrayList;

public class SelfCrossing {

    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3) return false;
        ArrayList<int[]> q = new ArrayList<>();
        int curX = 0;
        int curY = 0;
        q.add(new int []{curX, curY});

        for(int i = 0; i < x.length; i++){
            if(i % 4 == 0){
                curY += x[i];
            }else if(i % 4 == 1){
                curX -= x[i];
            }else if(i % 4 == 2){
                curY -= x[i];
            }else {
                curX += x[i];
            }

            q.add(new int []{curX, curY});
            if(q.size() > 7) q.remove(0);

            if(q.size() <= 4) continue;

            int last = q.size()-2;
            for(int j = 0; j < last-1; j++){
                if((last - j) % 2 == 1){
                    if(hvCross(q.get(last)[0], q.get(last)[1], q.get(last+1)[0], q.get(last+1)[1], q.get(j)[0], q.get(j)[1], q.get(j+1)[0], q.get(j+1)[1])) return true;
                }else {
                    if(paraCross(q.get(last)[0], q.get(last)[1], q.get(last+1)[0], q.get(last+1)[1], q.get(j)[0], q.get(j)[1], q.get(j+1)[0], q.get(j+1)[1])) return true;
                }
            }
        }
        return false;
    }

    private boolean hvCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        if(y1 == y2){
            if((x3-x1) * (x2-x3) >= 0 && (y1-y3) * (y4-y1) >= 0) return true; 
        } else {
            if((x1-x3) * (x4-x1) >= 0 && (y3-y1) * (y2-y3) >= 0) return true;
        }
        return false;
    }

    private boolean paraCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        if(x1 == x2 && x3 == x4){
            if(x1 != x3) return false;
            if(Math.min(y1, y2) > Math.max(y3, y4) || Math.max(y1, y2) < Math.min(y3, y4)) return false;
            return true;
        }else{
            if(y1 != y3) return false;
            if(Math.min(x1, x2) > Math.max(x3, x4) || Math.max(x1, x2) < Math.min(x3, x4)) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        SelfCrossing test = new SelfCrossing();
        int[] x = {1,1,2,2,1,1};
        System.out.println(test.isSelfCrossing(x));
    }

}