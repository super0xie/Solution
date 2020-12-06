import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod {
	
	public List<String> alertNames(String[] keyName, String[] keyTime) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < keyName.length; i++) {
        	if(!map.containsKey(keyName[i])) map.put(keyName[i], new ArrayList<>());
        	map.get(keyName[i]).add(keyTime[i]);
        }
        
        for(String name : map.keySet()) {
        	ArrayList<String> times = map.get(name);
        	Collections.sort(times);
        	for(int i = 0; i < times.size()-2; i++) {
        		int h1 = Integer.parseInt(times.get(i).substring(0, 2));
        		int h2 = Integer.parseInt(times.get(i+2).substring(0, 2));
        		if(h2-h1 > 1) continue;
        		if(h2-h1 == 0) {
        			res.add(name);
        			break;
        		}
        		
        		int m1 = Integer.parseInt(times.get(i).substring(3, 5));
        		int m2 = Integer.parseInt(times.get(i+2).substring(3, 5));
        		if(m2 <= m1) {
        			res.add(name);
        			break;
        		}
        	}
        }
        
        Collections.sort(res);
        return res;
        
    }
	
	public static void main(String[] args) {
		AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod test = new AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod();
		String[] keyName = {"a","a","a","a","b","b","b","b","b","b","c","c","c","c"};
		String[] keyTime = {"01:35","08:43","20:49","00:01","17:44","02:50","18:48","22:27","14:12","18:00","12:38","20:40","03:59","22:24"};
		test.alertNames(keyName, keyTime);
	}
	
}
