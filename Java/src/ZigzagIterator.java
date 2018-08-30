import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	
	private Iterator<Integer> i1;
	private Iterator<Integer> i2;
	private boolean first;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
        first = true;
        
        
    }

    public int next() {
    	int res = 0;
        if(first) {
        	if(i1.hasNext())
        		res = i1.next();
        	else
        		res = i2.next();
        	
        }else {
        	if(i2.hasNext())
        		res = i2.next();
        	else
        		res = i1.next();
        }
        first = !first;
        return res;
    }

    public boolean hasNext() {
    	return i1.hasNext() || i2.hasNext();
    }

}
