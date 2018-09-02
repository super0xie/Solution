import java.util.Arrays;
import java.util.Comparator;
public class CarFleet {
	
	private class Car{
		int position;
		double eta;
		
		double getPosition() {
			return position;
		}
	}
	
	public int carFleet(int target, int[] position, int[] speed) {
		if(position.length == 0) return 0;
		Car[] cars = new Car[position.length];
		
        for(int i = 0; i < position.length; i++) {
        	cars[i] = new Car();
        	cars[i].position = position[i];
        	cars[i].eta = ((double)(target - position[i]))/speed[i];
        }
		
        Arrays.sort(cars, Comparator.comparing(Car::getPosition));
        
        int res = 1;
        double preEta = cars[cars.length-1].eta;
        for(int i = cars.length-2; i >=0; i--) {
        	if(cars[i].eta > preEta) {
        		res++;
        		preEta = cars[i].eta;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		CarFleet test = new CarFleet();
		int target = 12;
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		
		System.out.println(test.carFleet(target, position, speed));
	}
	
	
}
