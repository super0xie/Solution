import java.util.HashSet;

public class CrackingtheSafe {
	
	private int total;
	private String res;
	private StringBuilder str;
	private HashSet<String> set;
	private int n;
	private int k;
	
    public String crackSafe(int n, int k) {
    	this.n = n;
    	this.k = k;
    	total = (int)Math.pow(k, n);
        str = new StringBuilder();
        set = new HashSet<String>();
        
        for(int i = 0; i < n; i++) {
        	str.append('0');
        }
        res = str.toString();
    	set.add(str.toString());
        
    	dfs();
        return res;
    }
    
    private boolean dfs() {
    	String prefix = str.substring(str.length()-n+1, str.length());
    	
    	for(int i = 0; i < k; i++) {
    		String newStr = prefix + i;
    		if(!set.contains(newStr)) {
    			str.append(i);
    			set.add(newStr);
    			if(set.size() == total) {
    				res = str.toString();
    				return true;
    			} else {
    				if(dfs()) return true;
    			}
    			str.deleteCharAt(str.length()-1);
    			set.remove(newStr);
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	CrackingtheSafe test = new CrackingtheSafe();
    	System.out.println(test.crackSafe(2, 2));
    }
    
}
