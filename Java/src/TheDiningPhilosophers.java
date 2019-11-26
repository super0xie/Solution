import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TheDiningPhilosophers {
	
	
	
	
//	public TheDiningPhilosophers() {
//        
//    }
	
//	private ReentrantLock lock = new ReentrantLock(true);
//	
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//    	lock.lock();
//    	try {
//    		pickLeftFork.run();
//    		pickRightFork.run();
//    		eat.run();
//    		putLeftFork.run();
//    		putRightFork.run();
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}finally {
//    		lock.unlock();
//    	}
//    	
//    }
    
    

	ReentrantLock[] forks = new ReentrantLock[5];
	
	public void DiningPhilosophers() {
        for(int i = 0; i < 5; i++) forks[i] = new ReentrantLock();
    }
    
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
    		
    	int left = philosopher;
    	int right = (philosopher+1) % 5;
    	
    	while(true) {
    		if(forks[left].isLocked() || forks[right].isLocked()) {
    			Thread.sleep(100);
    		}else {
    			forks[left].lock();
    			forks[right].lock();
    			
        		pickLeftFork.run();
        		pickRightFork.run();
        		eat.run();
        		putLeftFork.run();
        		putRightFork.run();
        		
        		forks[left].unlock();;
    			forks[right].unlock();
    			
    			break;
    		}
    		
    	}
    	
    		
    }
    	
    
    
    
    
    
    
    
    
    
}
