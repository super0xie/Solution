import java.util.HashSet;

public class WalkingRobotSimulation {
    
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0;
        HashSet<Long> set = new HashSet<Long>();
        for(int[] ob : obstacles) {
            set.add(encode(ob));
        }
        
        int res = 0;
        int x = 0;
        int y = 0;
        
        for(int i : commands) {
            if(i == -1) {
                dir += 1;
                if(dir == 4) dir = 0;
            }else if(i == -2) {
                dir -= 1;
                if(dir == -1) dir = 3;
            }else {
                for(int j = 0; j < i; j++) {
                    long m=x;
                    long n=y;
                    switch(dir) {
                    case 0:
                        n++;
                        break;
                    case 1:
                        m++;
                        break;
                    case 2:
                        n--;
                        break;
                    case 3:
                        m--;
                        break;
                    }
                    if(!set.contains(60000 * m + n)) {
                        x = (int)m;
                        y = (int)n;
                    }else {
                        break;
                    }
                }
                
                res = Math.max(res, x * x + y * y);
            }
        }
        
        
        return res;
    }
    
    private long encode(int[] ob) {
        return ob[0]* 60000 + ob[1];
    }
    
    public static void main(String[] args) {
        System.out.println(-1%4);
    }
}
