import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BuildingH2O {

    

    public void H2O() {
        
    }

    private ReentrantLock lock = new ReentrantLock(true);
    private LinkedList<Condition> hq = new LinkedList<>();
    private LinkedList<Condition> oq = new LinkedList<>();
    private int h = 0;
    private int o = 0;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();

        if(hq.size() >= 1 && oq.size() >= 1 && h == 0 && o == 0){
            Condition c1 = hq.poll();
            Condition c2 = oq.poll();
            c1.signal();
            c2.signal();
            h = 1;
            o = 1;
        }else{
            Condition c = lock.newCondition();
            hq.add(c);
            c.await();
            h--;

            buildNextMol();
        }

        releaseHydrogen.run();
        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();

        if(hq.size() >= 2 && h == 0 && o == 0){
            Condition c1 = hq.poll();
            Condition c2 = hq.poll();
            c1.signal();
            c2.signal();
            h = 2;
        }else{
            Condition c = lock.newCondition();
            oq.add(c);
            c.await();
            o--;

            buildNextMol();
        }
        
        releaseOxygen.run();
        
        lock.unlock();
    }

    private void buildNextMol(){
        if(h == 0 && o == 0 && hq.size() >= 2 && oq.size() >= 1){
            Condition c1 = hq.poll();
            Condition c2 = hq.poll();
            Condition c3 = oq.poll();
            c1.signal();
            c2.signal();
            c3.signal();
            h = 2;
            o = 1;
        }
    }


    public static void main(String[] args) {
        Runnable releaseHydrogen = new Runnable(){
            @Override
            public void run() {
                System.out.print("H");
            }
        };

        Runnable releaseOxygen = new Runnable(){
            @Override
            public void run() {
                System.out.print("O");
            }
        };

        BuildingH2O test = new BuildingH2O();

        Thread t1 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t2 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t3 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t4 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t5 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t6 = new Thread(()->{
            try{
                test.hydrogen(releaseHydrogen);
            }catch(Exception e){

            }
        });

        Thread t7 = new Thread(()->{
            try{
                test.oxygen(releaseOxygen);
            }catch(Exception e){

            }
        });

        Thread t8 = new Thread(()->{
            try{
                test.oxygen(releaseOxygen);
            }catch(Exception e){

            }
        });

        Thread t9 = new Thread(()->{
            try{
                test.oxygen(releaseOxygen);
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
        t8.start();
        t9.start();

    }
}