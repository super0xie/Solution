import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SetIntersectionSizeAtLeastTwo {
	
	
	class Interval{
		int s;
		int e;
		int count;
		
		Interval(int s, int e, int count){
			this.s = s;
			this.e = e;
			this.count = count;
		}
	}
	
	
	public int intersectionSizeTwoWrong(int[][] itv) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Interval> l = new HashSet<>();
        
        for(int[] i : itv) {
        	l.add(new Interval(i[0], i[1], 0));
        	for(int j = i[0]; j <= i[1]; j++) {
        		map.put(j, map.getOrDefault(j, 0)+1);
        	}
        }
        
        int res = 0;
        while(!l.isEmpty()) {
        	int k = 0;
        	int max = Integer.MIN_VALUE;
        	
        	for(int key : map.keySet()) {
        		if(map.get(key) > max) {
        			max = map.get(key);
        			k = key;
        		}
        	}
        	
        	ArrayList<Interval> toRemove = new ArrayList<>();
        	
        	for(Interval interval : l) {
        		if(k >= interval.s && k <= interval.e) {
        			interval.count++;
        			if(interval.count == 2) toRemove.add(interval);
        		}
        	}
        	
        	for(Interval interval : toRemove) {
        		l.remove(interval);
        		
        		for(int j = interval.s; j <= interval.e; j++) {
        			if(map.containsKey(j))
        				map.put(j, map.get(j)-1);
        		}
        	}
        	
        	map.remove(k);
        	res++;
        }
        
        return res;
    }
	
	public int intersectionSizeTwo(int[][] itv) {
        int res = 0;
        int[] todo = new int[itv.length];
        Arrays.fill(todo, 2);
        Arrays.sort(itv, (a, b)->{
        	if(a[0] != b[0]) {
        		return a[0]-b[0];
        	}else {
        		return b[1]-a[1];
        	}
        });
        
        int i = itv.length-1;
        
        while(i >= 0) {
        	int s = itv[i][0];
        	int e = itv[i][1];
        	
        	for(int j = s; j < s + todo[i]; j++) {
        		
        		for(int k = 0; k < i; k++) {
        			if(j <= itv[k][1] && todo[k] > 0) todo[k]--;
        		}
        		
        		res++;
        	}
        	i--;
        	
        }
        
        
        return res;
    }
	
	public static void main(String[] args) {
		SetIntersectionSizeAtLeastTwo test = new SetIntersectionSizeAtLeastTwo();
		int[][] itv = {{0,10},{0,2},{2,10},{0,6},{0,5},{4,8},{0,3},{6,8},{1,10},{0,1}};
		System.out.println(test.intersectionSizeTwo(itv));
		
		
	}
}
