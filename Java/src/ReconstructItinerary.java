import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class ReconstructItinerary {
	
	private class Ticket{
		String src, dst;
		
		Ticket(String src, String dst){
			this.src = src;
			this.dst = dst;
		}
	}
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets.length == 0) return res;
        Stack<String> stack = new Stack<String>();
        HashMap<String, List<Ticket>> map = new HashMap<String, List<Ticket>>();
        
        for(String[] ticket : tickets) {
        	List<Ticket> list = map.getOrDefault(ticket[0], new ArrayList<Ticket>());
        	list.add(new Ticket(ticket[0], ticket[1]));
        	map.put(ticket[0], list);
        }
        
        for(String key : map.keySet()) {
        	Collections.sort(map.get(key), (a,b)->{return a.dst.compareTo(b.dst);});
        }
        
        HashSet<Ticket> visited = new HashSet<Ticket>();
        
        dfs(map, "JFK", visited, stack);
        
        while(!stack.isEmpty()) {
        	res.add(stack.pop());
        }
        return res;
        
    }
	
	private void dfs(HashMap<String, List<Ticket>> map, String src, HashSet<Ticket> visited, Stack<String> stack) {
		if(!map.containsKey(src)) {
			stack.add(src);
			return;
		}
		
		List<Ticket> tickets = map.get(src);
		for(Ticket ticket : tickets) {
			if(!visited.contains(ticket)) {
				visited.add(ticket);
				dfs(map, ticket.dst, visited, stack);
			}
		}
		
		stack.add(src);
	}
	
	public static void main(String[] args) {
		ReconstructItinerary test = new ReconstructItinerary();
		String[][] tickets = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
		test.findItinerary(tickets);
	}
	
}
