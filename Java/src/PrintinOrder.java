import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintinOrder {

    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(1);

    public void Foo() {
        try{
            s1.acquire();
            s2.acquire();
        } catch(Exception e){

        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s1.release();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s2.release();
    }

    public static void main(String[] args) {
        Runnable printFirst = new Runnable(){
            @Override
            public void run() {
                System.out.println("first");
            }
        };

        Runnable printSecond = new Runnable(){
            @Override
            public void run() {
                System.out.println("second");
            }
        };

        Runnable printThird = new Runnable(){
            @Override
            public void run() {
                System.out.println("third");
            }
        };

        PrintinOrder test = new PrintinOrder();
        test.Foo();

        Thread t1 = new Thread(()->{
            try{
                test.first(printFirst);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
                test.second(printSecond);
            }catch(Exception e){

            }
        });

        Thread t3 = new Thread(()->{
            try{
                test.third(printThird);
            }catch(Exception e){

            }
        });

        t2.start();
        t3.start();
        t1.start();

    }
}