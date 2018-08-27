import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


public class NestedIterator implements Iterator<Integer> {

	private Iterator<NestedInteger> current;
	private Stack<Iterator<NestedInteger>> stack;
	private Integer next;
	
	public NestedIterator(List<NestedInteger> nestedList) {
        current = nestedList.iterator();
        stack = new Stack<Iterator<NestedInteger>>();
        next = nextHelper();
    }
	
	private Integer nextHelper() {
		if(current.hasNext()) {
			NestedInteger next = current.next();
			if(next.isInteger()) {
				while(!current.hasNext() && !stack.isEmpty()) {
					current = stack.pop();
				}
				return next.getInteger();
			}
			else {
				stack.push(current);
				current = next.getList().iterator();
				return nextHelper();
			}
		} else {
			while(!current.hasNext() && !stack.isEmpty()) {
				current = stack.pop();
			}
			
			if(!current.hasNext()) return null;
			else return nextHelper();
		}
		

	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		Integer result = next;
		next = nextHelper();
		
		return result;
	}
	
	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<NestedInteger>();
		List<NestedInteger> l1 = new ArrayList<NestedInteger>();
//		l1.add(new ImplementedNestedInteger(1));
//		l1.add(new ImplementedNestedInteger(1));
		NestedInteger e1 = new ImplementedNestedInteger(l1);
		NestedInteger e2 = new ImplementedNestedInteger(2);
		List<NestedInteger> l2 = new ArrayList<NestedInteger>();
		l2.add(new ImplementedNestedInteger(1));
		l2.add(new ImplementedNestedInteger(1));
		NestedInteger e3 = new ImplementedNestedInteger(l2);
		nestedList.add(e1);
		nestedList.add(e2);
//		nestedList.add(e3);
		
		
		
		
		
		NestedIterator test = new NestedIterator(nestedList);
//		System.out.println(test.hasNext());
		while(test.hasNext()) {
			System.out.println(test.next());
		}
		
		
	}

}
