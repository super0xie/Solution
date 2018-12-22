import java.util.LinkedList;

public class NumberofRecentCalls {
	
	LinkedList<Integer> list;
	public void RecentCounter() {
		list = new LinkedList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int aux = t-3000;
        while(list.peekFirst() < aux) {
        	list.pop();
        }
        return list.size();
    }
}
