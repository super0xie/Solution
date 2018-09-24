import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		List<Integer> res = new ArrayList<Integer>();
		
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < ppid.size(); i++) {
			List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
			children.add(pid.get(i));
			map.put(ppid.get(i), children);
		}
		
		res.add(kill);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(kill);
		
		while(!queue.isEmpty()) {
			int polled = queue.poll();
			
			List<Integer> children = map.getOrDefault(polled, null);
			
			if(children != null) {
				for(int child : children) {
					res.add(child);
					queue.add(child);
				}
				
			}
		}
		
		return res;
    }
}
