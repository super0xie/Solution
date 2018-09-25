
public class BeautifulArrangement {
	private int count;
	private int N;
    public int countArrangement(int N) {
        count = 0;
        this.N = N;
        boolean [] used = new boolean[N+1];
        dfs(1, used);
        return count;
    }
    private void dfs(int idx, boolean[] used) {
    	
    	for(int i = 1; i <= N; i++) {
    		if(!used[i] && ((i >= idx && i % idx == 0) || (i < idx && idx % i == 0))) {
    			if(idx == N) count++;
    			else {
    				used[i] = true;
    				dfs(idx+1, used);
    				used[i] = false;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	BeautifulArrangement test = new BeautifulArrangement();
    	test.countArrangement(2);
    }
    
}
