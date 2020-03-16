import java.util.ArrayList;
import java.util.HashMap;


public class TimeNeededtoInformAllEmployees {
    private int res;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < manager.length; i++) {
            if(manager[i] >= 0) {
                if(!map.containsKey(manager[i])) map.put(manager[i], new ArrayList<>());
                map.get(manager[i]).add(i);
            }
        }
        
        dfs(headID, map, informTime, 0);
        
        return res;
    }
    
    private void dfs(int n, HashMap<Integer, ArrayList<Integer>> map, int[] time, int cost) {
        res = Math.max(res, cost);
        if(map.containsKey(n)) {
            for(int adj : map.get(n)) {
                dfs(adj, map, time, cost+time[n]);
            }
        }
    }
    
}
