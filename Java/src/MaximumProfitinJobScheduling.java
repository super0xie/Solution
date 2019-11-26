import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class MaximumProfitinJobScheduling {

	
	class Job{
		int s;
		int e;
		int p;
		
		Job(int s, int e, int p){
			this.s = s;
			this.e = e;
			this.p = p;
		}
	}
	
	
	public int jobSchedulingTLE2(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job[] jobs = new Job[n];
		for(int i = 0; i < n; i++) jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		
		Arrays.sort(jobs, (a, b)->{return a.s - b.s;});
		
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        map.put(0, 0);
        
        for(int i = 0; i < n; i++) {
        	int max = Integer.MIN_VALUE;
        	
        	for(int key : map.headMap(jobs[i].s, true).keySet()) {
        		max = Math.max(max, map.get(key));
        	}
        	
        	if(max != Integer.MIN_VALUE)
        		map.put(jobs[i].e, Math.max(map.getOrDefault(jobs[i].e, 0), max + jobs[i].p));
        	
        }
        int res = 0;
        for(int key : map.keySet()) res = Math.max(map.get(key), res);
        return res;
    }
	
	public int jobSchedulingTLE(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job[] jobs = new Job[n];
		for(int i = 0; i < n; i++) jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		
		Arrays.sort(jobs, (a, b)->{return a.s - b.s;});
		
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 0);
        
        for(int i = 0; i < n; i++) {
        	HashMap<Integer, Integer> aux = new HashMap<>();
        	
        	for(int key : map.keySet()) {
        		if(jobs[i].s >= key) {
        			int p = map.get(key) + jobs[i].p;
        			aux.put(jobs[i].e, Math.max(aux.getOrDefault(jobs[i].e, 0), p));
        		}
        	}
        	
        	for(int key : aux.keySet()) {
        		map.put(key, Math.max(map.getOrDefault(key, 0), aux.get(key)));
        	}
        }
        
        int res = 0;
        for(int key : map.keySet()) res = Math.max(map.get(key), res);
        return res;
    }
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job[] jobs = new Job[n];
		int[] starts = new int[n];
		for(int i = 0; i < n; i++) jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		Arrays.sort(jobs, (a, b)->{return a.s - b.s;});
		for(int i = 0; i < n; i++) starts[i] = jobs[i].s;
		
		int[] dp = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i = n-1; i >= 0; i--) {
			int ret = Arrays.binarySearch(starts, jobs[i].e);
			int a = 0;
			if(ret >= 0) {
				while(ret > 0 && jobs[ret].s == jobs[ret-1].s) ret--;
				a = jobs[i].p + dp[ret];
			}else {
				int ip = -ret - 1;
				if(ip == n) a = jobs[i].p;
				else a = jobs[i].p + dp[ip];
			}
			
			dp[i] = Math.max(a, max);
			max = Math.max(max, dp[i]);
		}
		
		return dp[0];
    }
	
	public static void main(String[] args) {
		MaximumProfitinJobScheduling test = new MaximumProfitinJobScheduling();
//		ArrayList<int[]> l = TestcaseFileReader.getIntArrays();
//		int[] startTime = l.get(0);
//		int[] endTime = l.get(1);
//		int[] profit = l.get(2);
		
		int[] startTime = {1,2,3,3};
		int[] endTime = {3,4,5,6};
		int[] profit = {50,10,40,70};
		System.out.println(test.jobScheduling(startTime, endTime, profit));
	}
	
}
