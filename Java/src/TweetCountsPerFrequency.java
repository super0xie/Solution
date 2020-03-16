import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TweetCountsPerFrequency {
	
	public void TweetCounts() {
		
    }
	
	private HashMap<String, TreeMap<Integer, Integer>> data = new HashMap<>();
	
	
    
    public void recordTweet(String tweetName, int time) {
        if(!data.containsKey(tweetName)) data.put(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> map = data.get(tweetName);
        map.put(time, map.getOrDefault(time, 0)+1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = 0;
    	if(freq.equals("minute")) {
        	delta = 60;
        }else if(freq.equals("hour")) {
        	delta = 3600;
        }else {
        	delta = 86400;
        }
    	
    	List<Integer> res = new ArrayList<>();
    	TreeMap<Integer, Integer> map = data.get(tweetName);
    	if(map == null) return res;
    	
    	int start = startTime;
    	boolean cont = true;
    	while(cont) {
    		int end = start + delta - 1;
    		if(endTime <= end) {
    			end = endTime;
    			cont = false;
    		}
    		
    		int sum = 0;
    		for(int key : map.subMap(start, true, end, true).keySet()) {
    			sum += map.get(key);
    		}
    		
    		res.add(sum);
    		start += delta;
    	}
    	
    	return res;
    	
    }
    
    public static void main(String[] args) {
    	TweetCountsPerFrequency tweetCounts  = new TweetCountsPerFrequency();
    	tweetCounts.recordTweet("tweet3", 0);
    	tweetCounts.recordTweet("tweet3", 60);
    	tweetCounts.recordTweet("tweet3", 10); 
//    	tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);
    	List<Integer> res = tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
    	System.out.println("test");
    }
}
