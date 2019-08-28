import java.util.HashMap;

public class DesignFileSystem {
	
	class Node{
		HashMap<String, Node> map = new HashMap<>();
		int val;
		
		Node(int v){
			this.val = v;
		}
	}
	
	Node root = new Node(0);
	
	public void FileSystem() {
        
    }
    
    public boolean create(String path, int value) {
    	String[] strs = path.split("/");
        return createHelper(root, strs, 1, value);
    }
    
    private boolean createHelper(Node n, String[] strs, int i, int value) {
    	if(i == strs.length-1) {
    		Node node = new Node(value);
    		n.map.put(strs[i], node);
    		return true;
    	}else {
    		if(n.map.containsKey(strs[i])) {
    			return createHelper(n.map.get(strs[i]), strs, i+1, value);
    		}else {
    			return false;
    		}
    	}
    }
    
    public int get(String path) {
    	String[] strs = path.split("/");
        return getHelper(root, strs, 1);
    }
    
    
    private int getHelper(Node n, String[] strs, int i) {
    	if(n.map.containsKey(strs[i])) {
    		if(i == strs.length-1) {
    			return n.map.get(strs[i]).val;
        	}else {
        		return getHelper(n.map.get(strs[i]), strs, i+1);
        	}
    	}else {
    		return -1;
    	}
    }
    
    public static void main(String[] args) {
    	DesignFileSystem test = new DesignFileSystem();
    	test.create("/a", 1);
    	System.out.println(test.get("/a"));
    }

}
