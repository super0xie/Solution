import java.util.LinkedList;

public class JumpGameIII {
	
	public boolean canReach(int[] arr, int start) {
		
		if(arr[start] == 0) return true;
		
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        
        
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	
        	int i1 = idx - arr[idx];
        	int i2 = idx + arr[idx];
        	
        	
        	if(i1 >= 0 && i1 < arr.length && !visited[i1]) {
        		visited[i1] = true;
        		if(arr[i1] == 0) return true;
        		q.add(i1);
        	}
        	
        	if(i2 >= 0 && i2 < arr.length && !visited[i2]) {
        		visited[i2] = true;
        		if(arr[i2] == 0) return true;
        		q.add(i2);
        	}
        	
        	
        }
        
        return false;
        
        
    }
	
}
