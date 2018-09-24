import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OnlineElection {
	private ArrayList<Integer> winner;
    private ArrayList<Integer> time;
    
	public void TopVotedCandidate(int[] persons, int[] times) {
		winner = new ArrayList<Integer>();
		time = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        
        
        for(int i = 0; i < persons.length; i++) {
        	int count = map.getOrDefault(persons[i], 0)+1;
        	map.put(persons[i], count);
        	if(count >= max) {
        		max = count;
        		winner.add(persons[i]);
        		time.add(times[i]);
        	}
        }
    }
    
    public int q(int t) {
        int res = Collections.binarySearch(time, t);
        if(res >= 0) {
        	return winner.get(res);
        }else {
        	int ip = -res-1;
        	return winner.get(ip-1);
        }
    }
    
    public static void main(String[] args) {
    	int[] persons = {0,1,1,0,0,1,0};
    	int[] times = {0,5,10,15,20,25,30};
    	OnlineElection test = new OnlineElection();
    	test.TopVotedCandidate(persons, times);
    	test.q(3);
    	
    	
    }
}
