
public class BestPositionforaServiceCentre {
	
	public double getMinDistSumBad(int[][] p) {
        int n = p.length;
        double res = Double.MAX_VALUE;
        for(int i = 0; i < n-2; i++) {
        	for(int j = i+1; j < n-1; j++) {
        		for(int k = j+1; k < n; k++) {
        			double[] c = getCenter(p[i], p[j], p[k]);
        			if(c[0] == Double.POSITIVE_INFINITY || c[0] == Double.NEGATIVE_INFINITY) continue;
        			System.out.println(c[0] + ", " + c[1]);
        			double rs = (c[0]-p[i][0])*(c[0]-p[i][0])+(c[1]-p[i][1])*(c[1]-p[i][1]);
        			double r = Math.sqrt(rs);
        			double sum = r * 3;
        			int l = 0;
        			for(; l < n; l++) {
        				if(l == i || l == j || l == k) continue;
        				
        				double ds = (c[0]-p[l][0])*(c[0]-p[l][0])+(c[1]-p[l][1])*(c[1]-p[l][1]);
        				if(ds > rs) break;
        				
        				double d = Math.sqrt(ds);
        				sum += d;
        			}
        			
        			if(l == n) {
        				System.out.println(c[0] + ", " + c[1]);
        				return sum;
        			}
        		}
        	}
        }
        
        return -1d;
    }
	
	static double[] getCenter(int[] p1, int[] p2, int[] p3) {
		double x1 = p1[0];
		double y1 = p1[1];
		double x2 = p2[0];
		double y2 = p2[1];
		double x3 = p3[0];
		double y3 = p3[1];
		
		double e = 2 * (x2 - x1);
		double f = 2 * (y2 - y1);
	    double g = x2*x2 - x1*x1 + y2*y2 - y1*y1;
	    double a = 2 * (x3 - x2);
	    double b = 2 * (y3 - y2);
	    double c = x3*x3 - x2*x2 + y3*y3 - y2*y2;
	    
	    double X = (g*b - c*f) / (e*b - a*f);
	    double Y = (a*g - c*e) / (a*f - b*e);
	    
	    return new double[] {X, Y};
	}
	
	public double getMinDistSum(int[][] p) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        double x = 0;
        double y = 0;
        double res = getDisSum(x, y, p);
        double step = 50;
        while(step > 0.000001) {
        	int k = 0;
        	for(; k < dirs.length; k++) {
        		int[] dir = dirs[k];
        		double xx = x + step * dir[0];
        		double yy = y + step * dir[1];
        		double sum = getDisSum(xx, yy, p);
        		
        		if(sum < res) {
        			x = xx;
        			y = yy;
        			res = sum;
        			break;
        		}
        	}
        	
        	if(k == dirs.length) {
        		step = step / 2;
        	}
        	
        }
        
        return res;
    }
	
	
	private double getDisSum(double x, double y, int[][] p) {
		double sum = 0;
		for(int[] n : p) 
			sum += Math.sqrt((x-n[0]) * (x-n[0]) + (y-n[1]) * (y-n[1]));
		return sum;
	}
	
	
	
	
	
	public static void main(String[] args) {	
		BestPositionforaServiceCentre test = new BestPositionforaServiceCentre();
		
//		int[][] p = {{0,1},{3,2},{4,5},{7,6},{8,9},{11,1},{2,12}};
		int[][] p = {{1,1}};
		System.out.println(test.getMinDistSum(p));
	}
	
}
