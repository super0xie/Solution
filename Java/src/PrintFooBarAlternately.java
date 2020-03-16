import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternately {

    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c = lock.newCondition();
    private boolean foo = true;

    public void FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(foo){
                printFoo.run();
                foo = !foo;
            }else{
                i--;
                c.await();
            }
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(!foo){
                printBar.run();
                foo = !foo;
            }else{
                i--;
                c.signal();
            }
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        PrintFooBarAlternately test = new PrintFooBarAlternately();
        test.FooBar(3);

        Runnable printFoo = new Runnable(){
        
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Runnable printBar = new Runnable(){
        
            @Override
            public void run() {
                System.out.print("bar");
            }
        };

        Thread t1 = new Thread(()->{
            try{
                test.foo(printFoo);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
                test.bar(printBar);
            }catch(Exception e){

            }
        });

        t1.start();
        t2.start();



    }
}