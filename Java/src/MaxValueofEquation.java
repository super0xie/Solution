import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.TreeMap;

public class MaxValueofEquation {
//	TreeMap slow solution
//	public int findMaxValueOfEquation(int[][] points, int k) {
//        int l = 0;
//        int r = 0;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        int res = Integer.MIN_VALUE;
//        
//        while(r < points.length) {
//        	if(l >= r) {
//        		map.put(points[r][1]-points[r][0], map.getOrDefault(points[r][1]-points[r][0], 0)+1);
//        		r++;
//        		continue;
//        	}
//        	
//        	if(points[r][0]-points[l][0] > k) {
//        		int count = map.get(points[l][1]-points[l][0])-1;
//        		if(count == 0)
//        			map.remove(points[l][1]-points[l][0]);
//        		else
//        			map.put(points[l][1]-points[l][0], count);
//        		
//        		l++;
//        		continue;
//        	}
//        	
//        	int max = map.lastKey();
//        	res = Math.max(res, points[r][1]+points[r][0]+max);
//        	map.put(points[r][1]-points[r][0], map.getOrDefault(points[r][1]-points[r][0], 0)+1);
//        	r++;
//        }
//        
//        return res;
//    }
	
	
//	private void add(LinkedList<Integer> l, int v) {
//		while(!l.isEmpty() && v > l.peekLast()) {
//			l.pollLast();
//		}
//		l.addLast(v);
//	}
//	
//	private void remove(LinkedList<Integer> l, int v) {
//		if(!l.isEmpty() && l.peekFirst() == v) 
//			l.removeFirst();
//	}
//	
//	public int findMaxValueOfEquation(int[][] points, int k) {
//        int l = 0;
//        int r = 0;
//        LinkedList<Integer> list = new LinkedList<>();
//        int res = Integer.MIN_VALUE;
//        
//        while(r < points.length) {
//        	if(l >= r) {
//        		add(list, points[r][1]-points[r][0]);
//        		r++;
//        		continue;
//        	}
//        	
//        	if(points[r][0]-points[l][0] > k) {
//        		remove(list, points[l][1]-points[l][0]);
//        		l++;
//        		continue;
//        	}
//        	
//        	int max = list.getFirst();
//        	res = Math.max(res, points[r][1]+points[r][0]+max);
//        	add(list, points[r][1]-points[r][0]);
//        	r++;
//        }
//        
//        return res;
//    }
	
//	ArrayDeque is way better than linkedList
	private void add(ArrayDeque<Integer> l, int v) {
		while(!l.isEmpty() && v > l.peekLast()) {
			l.pollLast();
		}
		l.addLast(v);
	}
	
	private void remove(ArrayDeque<Integer> l, int v) {
		if(!l.isEmpty() && l.peekFirst() == v) 
			l.removeFirst();
	}
	
	public int findMaxValueOfEquation(int[][] points, int k) {
        int l = 0;
        int r = 0;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        
        while(r < points.length) {
        	if(l >= r) {
        		add(list, points[r][1]-points[r][0]);
        		r++;
        		continue;
        	}
        	
        	if(points[r][0]-points[l][0] > k) {
        		remove(list, points[l][1]-points[l][0]);
        		l++;
        		continue;
        	}
        	
        	int max = list.getFirst();
        	res = Math.max(res, points[r][1]+points[r][0]+max);
        	add(list, points[r][1]-points[r][0]);
        	r++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[][] points = {{-19,1},{-18,-13},{-17,-12},{-14,-14},{-8,-9},{-6,16},{-2,-4},{2,15},{4,19},{5,-9},{6,20},{7,-17},{16,3}};
		MaxValueofEquation test = new MaxValueofEquation();
		System.out.println(test.findMaxValueOfEquation(points, 5));
	}
	
}
