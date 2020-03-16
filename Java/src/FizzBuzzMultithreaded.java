import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
	
	private int n;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition condition = lock.newCondition();
	private int i = 1;
	
    public void FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	lock.lock();
    	try {
    		while(i <= n) {
    			if(i % 3 == 0 && i % 5 != 0) {
    				printFizz.run();
    				i++;
    			}
    			condition.signalAll();
    			if(i > n) break;
    			else condition.await();
        	}
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	lock.lock();
    	try {
    		while(i <= n) {
    			if(i % 5 == 0 && i % 3 != 0) {
    				printBuzz.run();
    				i++;
    			}
    			condition.signalAll();
    			if(i > n) break;
    			else condition.await();
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	lock.lock();
    	try {
    		while(i <= n) {
    			if(i % 5 == 0 && i % 3 == 0) {
    				printFizzBuzz.run();
    				i++;
    			}
    			condition.signalAll();
    			if(i > n) break;
    			else condition.await();
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	lock.lock();
    	try {
    		while(i <= n) {
    			if(i % 5 != 0 && i % 3 != 0) {
    				printNumber.accept(i);
    				i++;
    			}
    			condition.signalAll();
    			if(i > n) break;
    			else condition.await();
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		lock.unlock();
    	}
    }
    
    public static void main(String[] args) {
    	Runnable printFizz = new Runnable() {
			@Override
			public void run() {
				System.out.println("fizz");
			}
    	};
    	
    	Runnable printBuzz = new Runnable() {
			@Override
			public void run() {
				System.out.println("buzz");
			}
    	};
    	
    	Runnable printFizzBuzz = new Runnable() {
			@Override
			public void run() {
				System.out.println("fizzbuzz");
			}
    	};
    	
    	IntConsumer printNumber = new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println("" + value);
			}
    	};
    	
    	FizzBuzzMultithreaded test = new FizzBuzzMultithreaded();
    	test.FizzBuzz(10);
    	
    	Thread t1 = new Thread(()->{
            try{
                test.fizz(printFizz);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
            	test.buzz(printBuzz);
            }catch(Exception e){

            }
        });

        Thread t3 = new Thread(()->{
            try{
            	test.fizzbuzz(printFizzBuzz);
            }catch(Exception e){

            }
        });

        Thread t4 = new Thread(()->{
            try{
            	test.number(printNumber);
            }catch(Exception e){

            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("test");
    	
    	
    	
    }
    
    
}
