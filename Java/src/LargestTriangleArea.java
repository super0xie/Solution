
public class LargestTriangleArea {
    
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for(int i = 0; i < points.length-2; i++) {
            for(int j = i+1; j < points.length-1; j++) {
                for(int k = j+1; k < points.length; k++) {
                    double a = area(points[i], points[j], points[k]);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }
    
    private double area(int[] p1, int[] p2, int[] p3) {
        return Math.abs((double)(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - p1[0] * p3[1] - p2[0] * p1[1] - p3[0] * p2[1]) / 2);
    }
    
    public static void main(String[] args) {
        LargestTriangleArea test = new LargestTriangleArea();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(test.largestTriangleArea(points));
    }
    
}
