import java.util.HashSet;
import java.util.LinkedList;

public class DeleteOperationforTwoStrings {
	private class Node{
    	String l;
    	String r;
    	Node(String l, String r){
    		this.l = l;
    		this.r = r;
    	}
    }
	
	public int minDistanceTLE(String word1, String word2) {
		if(word1.equals(word2)) return 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        HashSet<String> visited = new HashSet<String>();
        
        
        queue.add(new Node(word1, word2));
        visited.add(word1+"/"+word2);
        int res = 1;
        while(!queue.isEmpty()) {
        	LinkedList<Node> aux = new LinkedList<Node>();
        	
        	while(!queue.isEmpty()) {
        		Node poped = queue.removeFirst();
        		if(poped.l.length() >= poped.r.length()) {
        			for(int i = 0; i < poped.l.length(); i++) {
            			String str = poped.l.substring(0, i) + poped.l.substring(i+1, poped.l.length());
            			if(str.equals(poped.r)) {
            				return res;
            			}
            			else {
            				if(!visited.contains(str+"/"+poped.r)) {
            					aux.add(new Node(str, poped.r));
            					visited.add(str+"/"+poped.r);
            				}
            			}
            		}
        		}else {
        			for(int i = 0; i < poped.r.length(); i++) {
            			String str = poped.r.substring(0, i) + poped.r.substring(i+1, poped.r.length());
            			if(str.equals(poped.l)) {
            				return res;
            			}
            			else {
            				if(!visited.contains(poped.l + "/" + str)) {
            					aux.add(new Node(poped.l, str));
            					visited.add(poped.l + "/" + str);
            				}
            			}
            		}
        		}
        	}
        	
        	queue = aux;
        	res++;
        }
        return res;
    }
	
	public int minDistance(String word1, String word2) {
		int[][] dp = new int [word1.length()+1][word2.length()+1];
		for(int i = 1; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		
		for(int i = 1; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= word1.length(); i++) {
			for(int j = 1; j <= word2.length(); j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		DeleteOperationforTwoStrings test = new DeleteOperationforTwoStrings();
		System.out.println(test.minDistanceTLE("abcdef", "ghijkl"));
	}

}
