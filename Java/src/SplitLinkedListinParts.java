import java.util.Arrays;

public class SplitLinkedListinParts {
	
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] res = new ListNode[k];
		
		int count = 0;
		ListNode p = root;
		while(p != null) {
			p = p.next;
			count++;
		}
		
		int[] len = new int[k];
		Arrays.fill(len, count/k);
		int rest = count % k;
		for(int i = 0; i < rest; i++) {
			len[i]++;
		}
		
		p = root;
		for(int i = 0; i < k; i++) {
			int c = len[i];
			if(c == 0) break;
			res[i] = p;
			ListNode pre = p;
			while(c > 0) {
				pre = p;
				p = p.next;
				c--;
			}
			pre.next = null;
			
		}
		
        
        return res;
    }
	
	public static void main(String[] args) {
		SplitLinkedListinParts test = new SplitLinkedListinParts();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		test.splitListToParts(n1, 5);
	}
	
}
