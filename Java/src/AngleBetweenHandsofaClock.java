
public class AngleBetweenHandsofaClock {
	
	public double angleClock(int hour, int minutes) {
        double a1 = (double)minutes/60 * 360;
        if(hour == 12) hour = 0;
        double a2 = 30 * hour + 30 * (double)minutes/60;
        
        double res = Math.abs(a1-a2);
        if(res > 180) res = 360 - res;
        return res;
    }
	
	
	public static void main(String[] args) {
		AngleBetweenHandsofaClock test = new AngleBetweenHandsofaClock();
		System.out.println(test.angleClock(12, 0));
	}
	
}
