import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;

public class AccountsMerge {
	
	private class Node{
		String name;
		Node parent;
		Node(String name){
			this.name = name;
		}
		
	}
	
	private Node getRoot(HashMap<String, Node> map, String str) {
		Node res = map.get(str);
		while(res.parent != null) res = res.parent;
		map.put(str, res);
		return res;
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<List<String>>();
        
        HashMap<String, Node> map = new HashMap<String, Node>();
        for(List<String> account : accounts) {
        	String name = null;
        	Node preRoot = null;
        	for(String str : account) {
        		if(name == null) {
        			name = str;
        		}else {
        			if(preRoot == null) {
        				if(!map.containsKey(str)) {
        					Node n = new Node(name);
        					map.put(str, n);
        					preRoot = n;
        				}else {
        					preRoot = getRoot(map, str);
        				}
        			}else {
        				if(map.containsKey(str)) {
        					Node root = getRoot(map, str);
        					if(root != preRoot)
        						root.parent = preRoot;
        				}else {
        					map.put(str, preRoot);
        				}
        			}
        		}
        	}
        }
        
        HashMap<Node, TreeSet<String>> res = new HashMap<Node, TreeSet<String>>();
        
        for(List<String> account : accounts) {
        	boolean first = true;
        	for(String str : account) {
        		if(first) {
        			first = false;
        		}else {
        			Node root = getRoot(map, str);
        			if(res.containsKey(root)) {
        				res.get(root).add(str);
        			}else {
        				TreeSet<String> set = new TreeSet<String>();
        				set.add(str);
        				res.put(root, set);
        			}
        		}
        	}
        }
        
        for(Node n : res.keySet()) {
        	List<String> person = new ArrayList<String>();
        	person.add(n.name);
        	for(String email : res.get(n)) {
        		person.add(email);
        	}
        	ret.add(person);
        	
        }
        return ret;
    }
	
	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<List<String>>();
		accounts.add(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
		accounts.add(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
		accounts.add(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
		accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
		accounts.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
		AccountsMerge test = new AccountsMerge();
		test.accountsMerge(accounts);
		
	}

}
