import java.util.Random;

public class GenerateRandomPointinaCircle {
    
    private double x;
    private double y;
    private double r;
    Random ran;
    public void Solution(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.r = radius;
        ran = new Random();
        
    }
    
    public double[] randPoint() {
        double ranR = Math.sqrt(ran.nextDouble());
        double dia = ranR * r;
        
        double thetaR = ran.nextDouble();
        double theta = thetaR * 2 * Math.PI;
        
        double y = this.y + dia * Math.sin(theta);
        double x = this.x + dia * Math.cos(theta);
        
        return new double[] {x, y};
    }
    
    public static void main(String[] args) {
        Random ran = new Random();
        for(int i = 0; i < 100; i++) {
            System.out.println(Math.sin(ran.nextDouble() * 2 * Math.PI));
        }
    }
}
