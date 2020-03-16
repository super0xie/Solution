import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBoundedBlockingQueue {
	
	private ReentrantLock lock = new ReentrantLock(true);
	private int cap;
	private LinkedList<Integer> queue;
	private Condition condition = lock.newCondition();
	
	public void BoundedBlockingQueue(int capacity) {
        cap = capacity;
        queue = new LinkedList<>();

    }
    
    public void enqueue(int element) throws InterruptedException {
    	lock.lock();
    	try {
    		while(queue.size() >= cap) {
        		condition.await();
        	}
        	
        	queue.add(element);
        	condition.signalAll();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
    	
    }
    
    public int dequeue() throws InterruptedException {
    	lock.lock();
    	int ret = -1;
    	try {
    		while(queue.isEmpty()) {
        		condition.await();
        	}
        	
        	ret = queue.poll();
        	condition.signalAll();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
        return ret;
    }
    
    
    public int size() {
        return queue.size();
    }
    
    public static void main(String[] args) {
    	DesignBoundedBlockingQueue test = new DesignBoundedBlockingQueue();
    	test.BoundedBlockingQueue(1);
    	
    	Thread t1 = new Thread(()->{
            try{
                test.enqueue(1);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
            	test.enqueue(2);
            }catch(Exception e){

            }
        });

        Thread t3 = new Thread(()->{
            try{
            	test.enqueue(3);
            }catch(Exception e){

            }
        });

        Thread t4 = new Thread(()->{
            try{
            	System.out.println(test.dequeue());
            }catch(Exception e){

            }
        });

        Thread t5 = new Thread(()->{
            try{
            	System.out.println(test.dequeue());
            }catch(Exception e){

            }
        });
        
        Thread t6 = new Thread(()->{
            try{
            	System.out.println(test.dequeue());
            }catch(Exception e){

            }
        });

        Thread t7 = new Thread(()->{
            try{
            	test.enqueue(4);
            }catch(Exception e){

            }
        });
        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        System.out.println("test");
    	
    }
    
}
