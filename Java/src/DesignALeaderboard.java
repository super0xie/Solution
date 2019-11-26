import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DesignALeaderboard {
	
	private HashMap<Integer, Integer> map;
	private TreeMap<Integer, Integer> tmap;
	
	public void Leaderboard() {
        map = new HashMap<>();
        tmap = new TreeMap<>((a, b)-> {return b-a;});
    }
    
    public void addScore(int playerId, int score) {
    	int old = 0;
        if(map.containsKey(playerId)) {
        	old = map.get(playerId);
        }
        int nValue = map.getOrDefault(playerId, 0) + score;
        map.put(playerId, nValue);
        
        if(old != 0) {
        	if(tmap.get(old) == 1) {
        		tmap.remove(old);
        	}else {
        		tmap.put(old, tmap.get(old)-1);
        	}
        }
        
        tmap.put(nValue, tmap.getOrDefault(nValue, 0)+1);
    }
    
    public int top(int K) {
    	int sum = 0;
        for(Entry<Integer, Integer> entry : tmap.entrySet()) {
        	int key = entry.getKey();
        	int count = entry.getValue();
        	
        	while(K > 0 && count > 0) {
        		sum += key;
        		count--;
        		K--;
        	}
        	
        	if(K == 0) break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
    	int old = map.get(playerId);
    	map.remove(playerId);
    	if(old != 0) {
        	if(tmap.get(old) == 1) {
        		tmap.remove(old);
        	}else {
        		tmap.put(old, tmap.get(old)-1);
        	}
        }
    }
    
    public static void main(String[] args) {
    	DesignALeaderboard leaderboard = new DesignALeaderboard();
    	leaderboard.Leaderboard();
    	leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
    	leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
    	leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
    	leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
    	leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
    	System.out.println(leaderboard.top(1));           // returns 73;
    	
    	leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
    	leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
    	leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
    	System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }
}
