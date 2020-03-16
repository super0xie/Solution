import java.util.concurrent.locks.ReentrantLock;

//import 

public class TrafficLightControlledIntersection {
	
	private boolean road1Green = true;
	private ReentrantLock lock = new ReentrantLock(true);
	
	public void TrafficLight() {
        
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        if((roadId == 1 && road1Green) || (roadId == 2 && !road1Green)) {
        	crossCar.run();
        }else {
        	lock.lock();
        	turnGreen.run();
        	road1Green = !road1Green;
        	crossCar.run();
        	lock.unlock();
        }
    }
}
