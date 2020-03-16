import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {
	
	
	public int nthSuperUglyNumberBad(int n, int[] primes) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int last = -1;
        
        pq.add(1);
        
        while(count < n) {
        	int polled = pq.poll();
        	
        	for(int i : primes) {
        		if(pq.size() > n-count+1) break;
        		int toAdd = polled * i;
        		if(toAdd / i == polled)
        			pq.add(polled * i);
        	}
        	
        	if(polled != last) count++;
        	last = polled;
        }
        
        return last;
    }
	
	class Num{
		int n;
		int i;
		
		Num(int n, int i){
			this.n = n;
			this.i = i;
		}
	}
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Num> pq = new PriorityQueue<>((a, b)->{return a.n - b.n;});
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int[] indice = new int[primes.length];
        Arrays.fill(indice, 1);
        
        for(int i = 0; i < primes.length; i++) {
        	pq.add(new Num(primes[i], i));
        }
        
        while(res.size() < n) {
        	Num polled = pq.poll();
        	if(polled.n != res.get(res.size()-1)) res.add(polled.n);
        	int toAdd = primes[polled.i] * res.get(indice[polled.i]);
        	pq.add(new Num(toAdd, polled.i));
        	indice[polled.i]++;
        }
        
        return res.get(n-1);
    }
	
	public static void main(String[] args) {
		int[] primes = {2,7,13,19};
		SuperUglyNumber test = new SuperUglyNumber();
		System.out.println(test.nthSuperUglyNumber(12, primes));
	}
	
}
