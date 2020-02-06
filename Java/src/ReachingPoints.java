import java.util.LinkedList;

public class ReachingPoints {
	
//	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        int g = gcd(sx, sy);
//        if(tx % g != 0 || ty % g != 0) return false;
//        
//        
//        return true;
//    }
//	
//	private int gcd(int a, int b) {
//		if(a < b) {
//			int tmp = a;
//			a = b;
//			b = tmp;
//		}
//		
//		while(b != 0) {
//			int t = b;
//			b = a % b;
//			a = t;
//		}
//		return a;
//	}
	
	public boolean reachingPointsTLE(int sx, int sy, int tx, int ty) {
		while(tx >= sx && ty >= sy) {
			if(tx == sx && ty == sy) return true;
			if(tx >= ty) {
				tx = tx - ty;
			}else {
				ty = ty - tx;
			}
		}
		
		return false;
    }
	
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        
        return (tx == sx && ty == sy);
    }
	
	
	public static void main(String[] args) {
//		LinkedList<int[]> q = new LinkedList<>();
//		q.add(new int[] {1, 0, 0, 1});
//		
//		for(int i = 0; i < 10; i++) {
//			LinkedList<int[]> aux = new LinkedList<>();
//			
//			while(!q.isEmpty()) {
//				int[] p = q.poll();
//				int s1 = p[0]+p[2];
//				int s2 = p[1]+p[3];
//				System.out.println(s1 + ", " + s2);
//				if(s1 == 2 && s2 == 2) System.out.println("hello");
//				aux.add(new int[] {p[0]+p[2], p[1]+p[3], p[2], p[3]});
//				aux.add(new int[] {p[0], p[1], p[0]+p[2], p[1]+p[3]});
//			}
//			
//			q = aux;
//		}
		
		ReachingPoints test = new ReachingPoints();
		
		System.out.print(test.reachingPoints(1, 6, 11, 10));
		
		
		
		
		
	}
}
