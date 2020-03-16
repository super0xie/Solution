import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceofaTeam {
	
	class Member {
		int s;
		int e;
		
		Member(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
	
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<Member> l = new ArrayList<>();
        int mod = 1_000_000_000 + 7;
        
        for(int i = 0; i < n; i++) {
        	l.add(new Member(speed[i], efficiency[i]));
        }
        
        Collections.sort(l, (a, b)->{
        	if(a.e != b.e) {
        		return b.e-a.e;
        	}else {
        		return b.s-a.s;
        	}
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{return a-b;});
        long sum = 0;
        long res = 0;
        for(int i = 0; i < n; i++) {
        	if(pq.size() < k) {
        		pq.add(l.get(i).s);
        		sum += l.get(i).s;
        	} else {
        		if(l.get(i).s > pq.peek()) {
        			sum += l.get(i).s - pq.peek();
        			pq.poll();
        			pq.add(l.get(i).s);
        		}
        	}
        	sum = sum % mod;
        	
        	
        	res = Math.max(res, sum * l.get(i).e);
        	
        }
        
        return (int)(res % mod);
    }
	
	public static void main(String[] args) {
		MaximumPerformanceofaTeam test = new MaximumPerformanceofaTeam();
		int[] speed = {2,8,2};
		int[] efficiency = {2,7,1};
		System.out.println(test.maxPerformance(100000, speed, efficiency, 86484));
	}
}
