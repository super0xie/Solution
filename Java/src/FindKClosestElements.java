import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
	
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		Comparator<Integer> cmp = (a,b)-> {
        	int i = Math.abs(a-x);
        	int j = Math.abs(b-x);
        	if(i != j) return j - i;
        	else return b-a;
        };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(cmp);
        for(int num : arr) {
        	if(pq.size() == k) {
        		int top = pq.peek();
        		if(cmp.compare(top, num) < 0) {
        			pq.poll();
        			pq.add(num);
        		}
        		
        	}else {
        		pq.add(num);
        	}
        }
        List<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty()) res.add(pq.poll());
        Collections.sort(res);
        return res;
    }
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		Comparator<Integer> cmp = (a,b)-> {
        	int i = Math.abs(a-x);
        	int j = Math.abs(b-x);
        	if(i != j) return i - j;
        	else return a - b;
        };
        List<Integer> res = new ArrayList<Integer>();
        
        int index = Arrays.binarySearch(arr, x);
        int i, j;
        if(index >= 0) {
        	i = index;
        	j = index+1;
        }else {
        	int ip = -index-1;
        	i = ip-1;
        	j = ip;
        }
        
        while(res.size() < k) {
        	if(i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
        		int compare = cmp.compare(arr[i], arr[j]);
        		if(compare <= 0) res.add(arr[i--]);
        		else res.add(arr[j++]);
        	}else if(j < 0 || j >= arr.length){
        		res.add(arr[i--]);
        	}else {
        		res.add(arr[j++]);
        	}
        }
        
        Collections.sort(res);
        return res;
    }
	
	public static void main(String[] args) {
		FindKClosestElements test = new FindKClosestElements();
		int[] arr = {1,2,3,4,5};
		test.findClosestElements(arr, 4, -1);
	}
}
