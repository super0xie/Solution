import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing {
	
	
//	public int makeArrayIncreasingWrong(int[] arr1, int[] arr2) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i : arr2) set.add(i);
//        int[] copy = new int[arr1.length];
//        for(int i = 0; i < arr1.length; i++) copy[i] = arr1[i];
//        
//        for(int i = 1; i < arr1.length; i++) {
//        	if(arr1[i] <= arr1[i-1]) {
//        		//reduce previous
//        		int min = Integer.MIN_VALUE;
//        		if(i != 1) min = arr1[i-2] + 1;
//        		Integer ceiling = set.ceiling(min);
//        		if(ceiling != null && ceiling < arr1[i]) {
//        			arr1[i-1] = ceiling;
//        			
//        			continue;
//        		}
//        		
//        		//increase cur
//        		min = arr1[i-1] + 1;
//        		ceiling = set.ceiling(min);
//        		if(ceiling != null && ceiling < arr1[i]) {
//        			arr1[i-1] = ceiling;
//        			
//        			continue;
//        		}
//        		
//        		//modify both
//        		min = Integer.MIN_VALUE;
//        		if(i != 1) min = arr1[i-2] + 1;
//        		Integer pre = set.ceiling(min);
//        		if(pre == null) return -1;
//        		Integer cur = set.ceiling(pre+1);
//        		if(cur == null) return -1;
//        		arr1[i-1] = pre;
//        		arr1[i] = cur;
//        		
//        	}
//        }
//        int res = 0;
//        
//        for(int i = 0; i < arr1.length; i++) {
//        	if(arr1[i] != copy[i]) res++;
//        }
//        
//        return res;
//    }
	
	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(-1, 0);
		
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : arr2) set.add(i);
		
		for(int i = 0; i < arr1.length; i++) {
			HashMap<Integer, Integer> cur = new HashMap<>();
			
			for(int key : map.keySet()) {
				int n = map.get(key);
				if(arr1[i] > key) cur.put(arr1[i], Math.min(cur.getOrDefault(arr1[i], Integer.MAX_VALUE), n));
				
				for(int j : set.tailSet(key, false)) {
					if(j == arr1[i]) continue;
					cur.put(j, Math.min(cur.getOrDefault(j, Integer.MAX_VALUE), n+1));
				}
				
			}
			
			if(cur.isEmpty()) return -1;
			
			ArrayList<Integer> l = new ArrayList<>();
			l.addAll(cur.keySet());
			Collections.sort(l);
			map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < l.size(); j++) {
				int k = cur.get(l.get(j));
				if(k < min) {
					map.put(l.get(j), k);
					min = k;
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		for(int i : map.keySet()) {
			res = Math.min(res, map.get(i));
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		MakeArrayStrictlyIncreasing test = new MakeArrayStrictlyIncreasing();
		ArrayList<int[]> res = TestcaseFileReader.getIntArrays();
		
		
		int[] arr1 = res.get(0);
		int[] arr2 = res.get(1);

		System.out.println(test.makeArrayIncreasing(arr1, arr2));
	}
	
}
