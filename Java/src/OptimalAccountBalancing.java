import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalAccountBalancing {
	
	private ArrayList<Integer> list;
	
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < transactions.length; i++) {
        	map.merge(transactions[i][0], -transactions[i][2], Integer::sum);
        	map.merge(transactions[i][1], transactions[i][2], Integer::sum);
        }
        
        list = new ArrayList<Integer>();
        for(int key : map.keySet()) {
        	if(map.get(key) != 0) list.add(map.get(key));
        }
        
        int result = dfs(0);
        return result;
        
    }
    
    private int dfs(int start) {
    	while(start < list.size() && list.get(start) == 0)
    		start++;
    	
    	if(start == list.size()) return 0;
    	
    	int res = Integer.MAX_VALUE;
    	for(int i = start+1; i < list.size(); i++) {
    		if(list.get(i) * list.get(start) < 0) {
    			list.set(i, list.get(i)+list.get(start));
    			res = Math.min(res, dfs(start+1)+1);
    			list.set(i, list.get(i)-list.get(start));
    		}
    	}
    	return res;
    }
    
    
    public static void main(String[] args) {
    	int[][] transactions = {{0,1,10},{2,0,5}};
    	OptimalAccountBalancing test = new OptimalAccountBalancing();
    	test.minTransfers(transactions);
    }
    
}
