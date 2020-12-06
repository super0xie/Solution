import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodinTheCity {
	
//	public int[] avoidFlood(int[] rains) {
//        int[] res = new int[rains.length];
//        TreeSet<Integer> t = new TreeSet<>();
//        HashMap<Integer, Integer> m = new HashMap<>();
//        for(int i = 0; i < rains.length; i++) {
//        	if(rains[i] == 0) {
//        		t.add(i);
//        		res[i] = 1;
//        	}else {
//        		if(m.containsKey(rains[i])) {
//        			Integer r = t.ceiling(m.get(rains[i]));
//        			if(r == null) return new int[] {};
//        			res[r] = rains[i];
//        			t.remove(r);
//        			m.remove(rains[i]);
//        		}else {
//        			m.put(rains[i], i);
//        		}
//        		res[i] = -1;
//        	}
//        }
//        return res;
//    }
	
	public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        TreeSet<Integer> t = new TreeSet<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < rains.length; i++) {
        	if(rains[i] == 0) {
        		t.add(i);
        		res[i] = 1;
        	}else {
        		if(m.containsKey(rains[i])) {
        			Integer r = t.ceiling(m.get(rains[i]));
        			if(r == null) return new int[] {};
        			res[r] = rains[i];
        			t.remove(r);
        			m.put(rains[i], i);
        		}else {
        			m.put(rains[i], i);
        		}
        		res[i] = -1;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		AvoidFloodinTheCity test = new AvoidFloodinTheCity();
		int[] res = test.avoidFlood(new int[] {2,3,0,0,3,1,0,1,0,2,2});
		for(int i : res) System.out.print(i + ", ");
	}
	
}
