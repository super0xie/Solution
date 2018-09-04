
public class FlipGameII {
	
	private boolean [] arr;
    public boolean canWin(String s) {
        arr = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
        	arr[i] = s.charAt(i) == '+';
        }
        
        return dfs();
    }
    
    private boolean dfs() {
    	
    	boolean canMove = false;
    	for(int i = 0; i < arr.length-1; i++) {
    		if(arr[i] && arr[i+1]) {
    			canMove = true;
    			arr[i] = false;
    			arr[i+1] = false;
    			boolean res = dfs();
    			arr[i] = true;
    			arr[i+1] = true;
    			if(!res) return true;
    		}
    	}
    	
    	if(!canMove) {
    		return false;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	FlipGameII test = new FlipGameII();
    	System.out.println(test.canWin("+++++++++"));
    	
    }
    
    
    
}
