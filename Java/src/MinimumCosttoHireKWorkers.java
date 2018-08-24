import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    
    private class Worker{
        int quality;
        int wage;
        double wq;
        
        Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.wq = ((double)wage) / quality;
        }
        
        double getWQ() {
            return wq;
        }
        
        
        
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int length = wage.length;
        
        Worker [] workers = new Worker [wage.length];
        for(int i = 0; i < wage.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        Arrays.sort(workers, Comparator.comparing(Worker::getWQ));
        
        
        PriorityQueue<Worker> pq = new PriorityQueue<Worker>(K, (a,b)->{
            return b.quality - a.quality;
        });
        
        double min = 0;
        int oldQSum = 0;
        for(int i = 0; i < K; i++) {
            min = min + workers[K-1].wq * workers[i].quality;
            pq.add(workers[i]);
            oldQSum += workers[i].quality;
        }
        
        
        for(int i = K; i < length; i++) {
            int currentMax = pq.peek().quality;
            
            if(workers[i].quality < currentMax) {
                oldQSum = oldQSum - currentMax + workers[i].quality;
                pq.poll();
                pq.add(workers[i]);
            }
            
            double newMin = workers[i].wq * oldQSum;
            if(newMin < min) {
                min = newMin;
            }
            
        }
        
        return min;
   
    }
    
    public static void main(String[] args) {
        int[] quality = {32,43,66,9,94,57,25,44,99,19};
        int[] wages = {187,366,117,363,121,494,348,382,385,262};
        
        MinimumCosttoHireKWorkers test = new MinimumCosttoHireKWorkers();
        System.out.println(test.mincostToHireWorkers(quality, wages, 4));;
        
    }

}
