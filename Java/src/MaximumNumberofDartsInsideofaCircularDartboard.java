
public class MaximumNumberofDartsInsideofaCircularDartboard {
	
	public int numPoints(int[][] points, int r) {
        double[][] ps = new double[points.length][2];
        for(int i = 0; i < points.length; i++) {
        	ps[i][0] = points[i][0];
        	ps[i][1] = points[i][1];
        }
        double r2 = (double)r * r + 0.01;
        int res = 1;
        for(int i = 0; i < points.length-1; i++) {
        	for(int j = i+1; j < points.length; j++) {
        		double[][] centers = getCenter(points[i], points[j], r);
        		if(centers != null) {
        			for(double[] c : centers) {
            			int count = 0;
            			
            			for(double[] p : ps) {
            				double d2 = getd2(p, c);
            				if(d2 <= r2) count++;
            			}
            			
            			res = Math.max(res, count);
            		}
        		}
        		
        	}
        }
        return res;
    }
	
	private double getd2(double[] p1, double[] p2) {
		return (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
	}
	
	private double[][] getCenter(int[] p1, int[] p2, int r) {
		int d2 = (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
		double d = Math.sqrt(d2);
		
		if(d2 > 4 * r * r) return null;
		else {
			double x3 = ((double)(p1[0]+p2[0]))/2;
			double y3 = ((double)(p1[1]+p2[1]))/2;
			
			if(d2 == 4 * r * r)
				return new double[][] {{x3, y3}};
			else {
				double[][] ret = new double[2][2];
				
				ret[0][0] = x3 + Math.sqrt(r*r-(d/2)*(d/2))*(p1[1]-p2[1])/d;
				ret[0][1] = y3 + Math.sqrt(r*r-(d/2)*(d/2))*(p2[0]-p1[0])/d;
				ret[1][0] = x3 - Math.sqrt(r*r-(d/2)*(d/2))*(p1[1]-p2[1])/d;
				ret[1][1] = y3 - Math.sqrt(r*r-(d/2)*(d/2))*(p2[0]-p1[0])/d;
				
				return ret;
			}
				
		} 
			
		
	}
	
	public static void main(String[] args) {
		MaximumNumberofDartsInsideofaCircularDartboard test = new MaximumNumberofDartsInsideofaCircularDartboard();
		int[][] points = {{4,5},{-4,1},{-3,2},{-4,0},{0,2}};
		System.out.println(test.numPoints(points, 5));
		
	}
}
