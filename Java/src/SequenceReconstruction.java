import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class SequenceReconstruction {
	
	boolean hasCycle = false;
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    	HashSet<Integer> orgSet = new HashSet<Integer>();
    	for(int i : org) orgSet.add(i);
    	
    	
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for(List<Integer> list : seqs) {
        	int prev = Integer.MIN_VALUE;
        	for(int i : list) {
        		if(!orgSet.contains(i)) return false;
        		if(prev != Integer.MIN_VALUE) {
        			if(map.containsKey(prev)) {
        				HashSet<Integer> set = map.get(prev);
        				set.add(i);
        			}else {
        				HashSet<Integer> set = new HashSet<Integer>();
        				set.add(i);
        				map.put(prev, set);
        			}
        		}
        		prev = i;
        	}
        }
        if(map.size()==0) {
        	if(org.length ==1) {
        		if(seqs.size() == 0) return false;
        		for(List<Integer> list : seqs) {
            		if(!(list.size() == 1 && list.get(0) == org[0])) return false;
            	}
        	}
        	return true;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<Integer> onStack = new HashSet<Integer>();
        
        dfs(org[0], stack, onStack, visited, map);
        if(hasCycle) return false;
        if(stack.size() != org.length) return false;
        for(int i = 0; i < org.length; i++) {
        	int poped = stack.pop();
        	if(poped != org[i]) return false;
        	if(i != org.length-1) {
        		if(!map.containsKey(org[i])) return false;
        		if(!map.get(org[i]).contains(org[i+1])) return false;
        	}
        }
        
        return true;
    }
    
    private void dfs(int i, Stack<Integer> stack, HashSet<Integer> onStack,
    		HashSet<Integer> visited, HashMap<Integer, HashSet<Integer>> map) {
    	if(onStack.contains(i)) {
    		hasCycle = true;
    		return;
    	}
    	
    	if(visited.contains(i)) return;
    	
    	visited.add(i);
    	onStack.add(i);
    	
    	if(map.containsKey(i)) {
    		for(int adj : map.get(i)) {
    			dfs(adj, stack, onStack, visited, map);
    			if(hasCycle) return;
    		}
    	}
    	
    	onStack.remove(i);
    	stack.add(i);
    }
    
    public static void main(String[] args) {
    	SequenceReconstruction test = new SequenceReconstruction();
    	int[] org = {1};
    	List<List<Integer>> seqs = new ArrayList<List<Integer>>();
    	seqs.add(Arrays.asList(1));
    	seqs.add(Arrays.asList(1));
    	seqs.add(Arrays.asList(1));
    	System.out.println(test.sequenceReconstruction(org, seqs));
    }
    
}
