import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NetworkDelayTime {
    
    class Node{
        int src;
        int dis;
        Node(int src, int dis){
            this.src = src;
            this.dis = dis;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, Integer>[] graph = new HashMap[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new HashMap<Integer, Integer>();
        }
        
        for(int[] time : times) {
            graph[time[0]].put(time[1], time[2]); 
        }
        
        int[] disTo = new int[N+1];
        Arrays.fill(disTo, Integer.MAX_VALUE);
        disTo[K] = 0;
        disTo[0] = 0;
        
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(K, 0));
        
        while(!queue.isEmpty()) {
            Node polled = queue.poll();
            
            for(int dst : graph[polled.src].keySet()) {
                int dis = polled.dis + graph[polled.src].get(dst);
                if(dis < disTo[dst]) {
                    disTo[dst] = dis;
                    queue.add(new Node(dst, dis));
                }
            }
        }
        
        int res = 0;
        for(int i = 1; i <= N; i++) {
            if(disTo[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, disTo[i]);
        }
        
        return res;
    }
    
}
