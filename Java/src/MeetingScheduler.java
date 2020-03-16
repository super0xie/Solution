import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MeetingScheduler {
	
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        for(int[] inter : slots1) {
        	map.put(inter[0], map.getOrDefault(inter[0], 0) + 1);
        	map.put(inter[1], map.getOrDefault(inter[1], 0) - 1);
        }
        
        for(int[] inter : slots2) {
        	map.put(inter[0], map.getOrDefault(inter[0], 0) + 1);
        	map.put(inter[1], map.getOrDefault(inter[1], 0) - 1);
        }
        
        int sum = 0;
        int start = 0;
        for(int key : map.keySet()) {
        	int aux = sum;
        	sum += map.get(key);
        	
        	if(sum == 2) {
        		start = key;
        	} else {
        		if(aux == 2 && key - start >= duration) {
        			res.add(start);
        			res.add(start + duration);
        			return res;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		MeetingScheduler test = new MeetingScheduler();
		int[][] slots1 = {{10,50},{60,120},{140,210}};
		int[][] slots2 = {{0,15},{60,70}};
		List<Integer> res = test.minAvailableDuration(slots1, slots2, 12);
		if(res.size() == 2)
			System.out.println(res.get(0) + ", " + res.get(1));
		else
			System.out.println("{}");
		
	}
}
