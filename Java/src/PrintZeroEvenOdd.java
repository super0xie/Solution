import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintZeroEvenOdd{

    private class IntConsumer{
        public void accept(int n){
            System.out.print(n);
        }
    }

    private int n;
    private int i = 1;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition c0 = lock.newCondition();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    
    public void ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(true){
            lock.lock();
            if(i > 2 * n) {
            	try {
            		c1.signal();
                	break;
            	}finally {
            		lock.unlock();
            	}
            	
            }

            if(i % 2 == 1){
                printNumber.accept(0);
                i++;
            }
            
            
            if((i/2) % 2 == 1) c1.signal();
            else c2.signal();
            c0.await();
            
                
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            lock.lock();
            
            
            if(i % 2 != 1 && (i/2) % 2 == 0){
                printNumber.accept(i/2);
                i++;
            }
            c0.signal();
            c2.await();
            if(i > 2 * n) {
            	break;
            }
            
            
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            lock.lock();
            
            if(i % 2 != 1 && (i/2) % 2 == 1){
                printNumber.accept(i/2);
                i++;
            }
            c0.signal();
            c1.await();
            if(i > 2 * n) {
            	try {
            		c2.signal();
                	break;
            	}finally {
            		lock.unlock();
            	}
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd test = new PrintZeroEvenOdd();
        IntConsumer ic = test.new IntConsumer();
        test.ZeroEvenOdd(2);

        Thread t1 = new Thread(()->{
            try{
                test.zero(ic);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
                test.even(ic);
            }catch(Exception e){

            }
        });

        Thread t3 = new Thread(()->{
            try{
                test.odd(ic);
            }catch(Exception e){

            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}