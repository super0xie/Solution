
public class AirplaneSeatAssignmentProbability {
	
	public double nthPersonGetsNthSeat(int n) {
		if(n == 1) return 1;
		return 0.5;
    }
	
	public static void main(String[] args) {
		AirplaneSeatAssignmentProbability test = new AirplaneSeatAssignmentProbability();
		System.out.println(test.nthPersonGetsNthSeat(5));
	}
	
}
