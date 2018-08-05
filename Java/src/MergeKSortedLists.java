import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	private class TaggedListNode implements Comparable<TaggedListNode>{
		ListNode node;
		int index;
		TaggedListNode(ListNode node, int index){
			this.node = node;
			this.index = index;
		}
		
		@Override
		public int compareTo(TaggedListNode o) {
			// TODO Auto-generated method stub
			if(this.node.val > o.node.val) return 1;
			else if(this.node.val < o.node.val) return -1;
			else return 0;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        PriorityQueue<TaggedListNode> pq = new PriorityQueue<TaggedListNode>();
        
        for(int i = 0; i < lists.length; i++) {
        	if(lists[i] == null) continue;
        	pq.add(new TaggedListNode(lists[i], i));
        	lists[i] = lists[i].next;
        }
        
        while(!pq.isEmpty()) {
        	TaggedListNode node = pq.remove();
        	tail.next = node.node;
        	tail = tail.next;
        	
        	if(lists[node.index] != null) {
        		pq.add(new TaggedListNode(lists[node.index], node.index));
        		lists[node.index] = lists[node.index].next;
        	}
        }
        
        ListNode result = head.next;
        head.next = null;
        return result;   
    }

}
