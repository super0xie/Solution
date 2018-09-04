import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BusRoutes {
	
	
	
    public int numBusesToDestination(int[][] routes, int S, int T) {
    	if(S == T) return 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        for(int i = 0; i < routes.length; i++) {
        	for(int j = 0; j < routes[i].length; j++){
        		HashSet<Integer> set = map.getOrDefault(routes[i][j], new HashSet<Integer>());
        		set.add(i);
        		map.put(routes[i][j], set);
        	}
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(S);
        int res = 1;
        while(!queue.isEmpty()) {
        	LinkedList<Integer> aux = new LinkedList<Integer>();
        	while(!queue.isEmpty()) {
        		int poped = queue.removeFirst();
        		visited.add(poped);
        		for(int route : map.get(poped)) {
        			for(int i : routes[route]) {
        				if(i == T) return res;
            			if(!visited.contains(i)) {
            				aux.add(i);
            			}
        			}
        			
        		}
        	}
        	queue = aux;
        	res++;
        }
        
        return -1;
    }
    
    public int numBusesToDestinationTLE(int[][] routes, int S, int T) {
    	if(S == T) return 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        ArrayList<HashSet<Integer>> route = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < routes.length; i++) {
        	HashSet<Integer> set = new HashSet<Integer>();
        	for(int j = 0; j < routes[i].length; j++) {
        		set.add(routes[i][j]);
        	}
        	route.add(set);
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(S);
        int res = 1;
        while(!queue.isEmpty()) {
        	LinkedList<Integer> aux = new LinkedList<Integer>();
        	while(!queue.isEmpty()) {
        		int poped = queue.removeFirst();
        		visited.add(poped);
        		for(int i = 0; i < route.size(); i++) {
        			if(route.get(i).contains(poped)) {
        				for(int j = 0; j < routes[i].length; j++) {
        					if(routes[i][j] == T) return res;
        					if(!visited.contains(routes[i][j])) {
                				aux.add(routes[i][j]);
                			}
        				}
        			}
        		}
        		
        	}
        	queue = aux;
        	res++;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
    	BusRoutes test = new BusRoutes();
    	int[][] routes = {{1, 2, 7}, {3, 6, 7}};
    	System.out.println(test.numBusesToDestination(routes, 1, 6));
    }
    
}
