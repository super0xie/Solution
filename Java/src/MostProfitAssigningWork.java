import java.util.Arrays;

public class MostProfitAssigningWork {
    
    class Job {
        int d;
        int p;
        
        Job(int d, int p){
            this.d = d;
            this.p = p;
        }
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobs = new Job[difficulty.length];
        for(int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a,b)->{
            if(a.d != b.d)
                return a.d - b.d;
            else
                return a.p - b.p;
        });
        
        int [] maxP = new int [profit.length];
        int max = jobs[0].p;
        
        for(int i = 0; i < profit.length; i++) {
            max = Math.max(max, jobs[i].p);
            maxP[i] = max;
        }
        
        int res = 0;
        for(int work : worker) {
            if(work < jobs[0].d) continue;
            
            int l = 0;
            int r = jobs.length-1;
            int mid = 0;
            
            while(l < r) {
                mid = r - (r-l)/2;
                if(jobs[mid].d <= work) l = mid;
                else r = mid-1;
            }
            
            res += maxP[l];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        MostProfitAssigningWork test = new MostProfitAssigningWork();
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        
        test.maxProfitAssignment(difficulty, profit, worker);
    }
    
}
