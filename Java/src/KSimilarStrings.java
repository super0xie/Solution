import java.util.HashSet;
import java.util.LinkedList;

public class KSimilarStrings {
	
    public int kSimilarity(String A, String B) {
    	if(A.equals(B)) return 0;
    	HashSet<String> visited = new HashSet<String>();
    	LinkedList<String> queue = new LinkedList<String>();
    	
    	queue.add(A);
    	int res = 1;
    	while(!queue.isEmpty()) {
    		LinkedList<String> aux = new LinkedList<String>();
    		while(!queue.isEmpty()) {
    			String poped = queue.pop();
    			visited.add(poped);
    			int i = 0;
        		while(i < poped.length() && poped.charAt(i) == B.charAt(i)) i++;
    			
    			for(int j = i; j < poped.length(); j++) {
    				if(poped.charAt(j) == B.charAt(j)) continue;
    				if(poped.charAt(i) != B.charAt(j)) continue;
    				//swap i and j
    				String swapped = swap(poped, i, j);
    				if(B.equals(swapped)) return res;
    				if(visited.contains(swapped)) continue;
    				aux.add(swapped);
    			}
    		}
    		res++;
    		queue = aux;
    	}
    	
    	return -1;
    }
    
    class Node {
    	String path;
    	String cur;
    	Node(String p, String cur){
    		this.path = p;
    		this.cur = cur;
    	}
    }
    
    public int kSimilarityWithPath(String A, String B) {
    	if(A.equals(B)) return 0;
    	HashSet<String> visited = new HashSet<String>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	
    	queue.add(new Node("", A));
    	int res = 1;
    	while(!queue.isEmpty()) {
    		LinkedList<Node> aux = new LinkedList<Node>();
    		while(!queue.isEmpty()) {
    			Node poped = queue.pop();
    			visited.add(poped.cur);
    			int i = 0;
        		while(i < poped.cur.length() && poped.cur.charAt(i) == B.charAt(i)) i++;
    			
    			for(int j = i; j < poped.cur.length(); j++) {
    				if(poped.cur.charAt(j) == B.charAt(j)) continue;
    				if(poped.cur.charAt(i) != B.charAt(j)) continue;
    				//swap i and j
    				String swapped = swap(poped.cur, i, j);
    				if(B.equals(swapped)) {
    					System.out.println(poped.path+ i + "<->" + j + " "); 
    					return res;
    				}
    				if(visited.contains(swapped)) continue;
    				
    				aux.add(new Node(poped.path+ i + "<->" + j + " ", swapped));
    			}
    		}
    		res++;
    		queue = aux;
    	}
    	
    	return -1;
    }
    
    private String swap(String str, int i, int j) {
    	char [] chars = str.toCharArray();
    	char aux = chars[i];
    	chars[i] = chars[j];
    	chars[j] = aux;
    	return String.valueOf(chars);
    }
    
    public static void main(String[] args) {
    	KSimilarStrings test = new KSimilarStrings();
    	System.out.println(test.kSimilarityWithPath("aabc", "abca"));
    	
    }

}
