import java.util.ArrayList;
import java.util.HashMap;

public class DesignUndergroundSystem {
	
	public void UndergroundSystem() {
        
    }
	
	class Pass{
		String station;
		int t;
		
		Pass(String s, int time){
			station = s;
			t = time;
		}
	}
	
	private HashMap<String, HashMap<String, ArrayList<Integer>>> log = new HashMap<>();
	private HashMap<Integer, Pass> pending = new HashMap<>();
	
    public void checkIn(int id, String stationName, int t) {
        pending.put(id, new Pass(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pass s = pending.remove(id);
        if(!log.containsKey(s.station)) log.put(s.station, new HashMap<>());
        if(!log.get(s.station).containsKey(stationName)) log.get(s.station).put(stationName, new ArrayList<>());
        log.get(s.station).get(stationName).add(t-s.t);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if(!log.containsKey(startStation)) return 0;
        if(!log.get(startStation).containsKey(endStation)) return 0;
        
        double sum = log.get(startStation).get(endStation).stream().mapToInt(Integer::intValue).sum();
        return sum / log.get(startStation).get(endStation).size();
    }
}
