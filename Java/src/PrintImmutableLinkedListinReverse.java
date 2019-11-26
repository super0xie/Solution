import java.util.Stack;

public class PrintImmutableLinkedListinReverse {
	
	interface ImmutableListNode {
		 public void printValue(); // print the value of this node.
		 public ImmutableListNode getNext(); // return the next node.
	}
	
	public void printLinkedListInReverse(ImmutableListNode head) {
		Stack<ImmutableListNode> s = new Stack<>();
		while(head != null) {
			s.add(head);
			head = head.getNext();
		}
		
		while(!s.isEmpty()) {
			s.pop().printValue();
		}
	
    }
}
