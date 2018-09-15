import java.util.HashMap;
import java.util.HashSet;

public class LinkedListComponents {
	
	public int numComponents(ListNode head, int[] G) {
        HashMap<Integer, Integer> uf = new HashMap<Integer, Integer>();
        
        for(int num : G) {
        	uf.put(num, num);
        }
        
        ListNode p = head;
        while(p != null && p.next != null) {
        	if(uf.containsKey(p.val) && uf.containsKey(p.next.val)) {
        		int rootP = getRoot(uf, p.val);
        		int rootN = getRoot(uf, p.next.val);
        		if(rootP != rootN) {
        			uf.put(rootP, rootN);
        		}
        	}
        	
        	p = p.next;
        }
        
        HashSet<Integer> res = new HashSet<Integer>();
        
        for(int num : G) {
        	int root = getRoot(uf, num);
        	res.add(root);
        }
        
        return res.size();
    }
	
	private int getRoot(HashMap<Integer, Integer> uf, int num) {
		if(uf.get(num) == num) return num;
		else {
			int res = getRoot(uf, uf.get(num));
			uf.put(num, res);
			return res;
		}
	}

}
