
public class CountUnhappyFriends {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] aux = new int[n][n];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n-1; j++) {
        		int f = preferences[i][j];
        		aux[i][f] = j;
        	}
        }
        
        int[] p = new int[n];
        for(int[] pair : pairs) {
        	p[pair[0]] = pair[1];
        	p[pair[1]] = pair[0];
        }
        
        int res = 0;
        
        for(int i = 0; i < n; i++) {
        	int pair = p[i];
        	for(int j = 0; preferences[i][j] != pair; j++) {
        		int other = preferences[i][j];
        		int otherPair = p[other];
        		if(aux[other][i] < aux[other][otherPair]) {
        			res++;
        			break;
        		}
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		CountUnhappyFriends test = new CountUnhappyFriends();
		int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
		int[][] pairs = {{1, 3}, {0, 2}};
		test.unhappyFriends(4, preferences, pairs);
	}
}
