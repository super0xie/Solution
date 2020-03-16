import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class JumpGameIV {
	
	public int minJumps(int[] arr) {
        if(arr.length == 1) return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        
        for(int i = 0; i < arr.length; i++) {
        	if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
        	map.get(arr[i]).add(i);
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        int step = 1;
        
        while(!q.isEmpty()) {
        	LinkedList<Integer> aux = new LinkedList<>();
        	
        	while(!q.isEmpty()) {
        		int polled = q.poll();
        		
        		if(polled > 0 && !visited[polled-1]) {
        			visited[polled-1] = true;
        			aux.add(polled-1);
        		}
        		
        		if(!visited[polled+1]) {
        			visited[polled+1] = true;
        			if(polled+1 == arr.length-1) return step;
        			aux.add(polled+1);
        		}
        		
        		if(map.containsKey(arr[polled])) {
        			for(int i : map.get(arr[polled])) {
        				if(!visited[i]) {
        					visited[i] = true;
        					if(i == arr.length-1) return step;
        					aux.add(i);
        				}
        			}
        			
        			map.remove(arr[polled]);
        		}
        	}
        	
        	q = aux;
        	step++;
        }
        
        return -1;

    }
	
	public static void main(String[] args) {
		JumpGameIV test = new JumpGameIV();
		int[] arr = {11,22,7,7,7,7,7,7,7,22,13};
		System.out.println(test.minJumps(arr));
	}
	
}
