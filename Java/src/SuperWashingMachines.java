import java.util.ArrayList;
import java.util.LinkedList;

public class SuperWashingMachines {
	
//	class Pair{
//		int idx;
//		int val;
//		
//		Pair(int i, int n){
//			idx = i;
//			val = n;
//		}
//	}
//	
//	
//	public int findMinMoves(int[] m) {
//        int sum = 0;
//        for(int i : m) sum += i;
//        if(sum % m.length != 0) return -1;
//        
//        int target = sum / m.length;
//        
//        ArrayList<Pair>[] task = new ArrayList[m.length];
//        LinkedList<Pair> provider = new LinkedList<>();
//        LinkedList<Pair> consumer = new LinkedList<>();
//        
//        for(int i = 0; i < m.length; i++) {
//        	if(m[i] == target) continue;
//        	
//        	if(m[i] > target) {
//        		task[i] = new ArrayList<>();
//        		int n = m[i]-target;
//        		
//        		while(n > 0 && !consumer.isEmpty()) {
//        			Pair first = consumer.getFirst();
//        			if(n >= first.val) {
//        				n -= first.val;
//        				consumer.poll();
//        				task[i].add(new Pair(first.idx, first.val));
//        			}else {
//        				first.val -= n;
//        				task[i].add(new Pair(first.idx, n));
//        				n = 0;
//        				
//        			}
//        		}
//        		
//        		if(n > 0) {
//        			provider.add(new Pair(i, n));
//        		}
//        	} else {
//        		int n = target - m[i];
//        		
//        		while(n > 0 && !provider.isEmpty()) {
//        			Pair first = provider.getFirst();
//        			if(n >= first.val) {
//        				n -= first.val;
//        				provider.poll();
//        				task[first.idx].add(new Pair(i, first.val));
//        			}else {
//        				first.val -= n;
//        				n = 0;
//        				task[first.idx].add(new Pair(i, n));
//        			}
//        		}
//        		
//        		if(n > 0) {
//        			consumer.add(new Pair(i, n));
//        		}
//        		
//        	}
//        	
//        }
//        
//        
//        int max = 0;
//        for(int i = 0; i < m.length; i++) {
//        	if(task[i] == null) continue;
//        	int n = m[i]-target;
//        	int cur = n;
//        	for(Pair p : task[i]) {
//        		int diff = Math.abs(p.idx - i);
//        		cur = Math.max(cur, p.val + diff -1);
//        	}
//        	
//
//        	max = Math.max(max, cur);
//        }
//        
//        return max;
//    }
//	
//	public static void main(String[] args) {
//		SuperWashingMachines test = new SuperWashingMachines();
//		int[] m = {0,0,11,5};
//		System.out.println(test.findMinMoves(m));
//	}
	
}
