import java.util.LinkedList;

public class MovingAveragefromDataStream {
	
	private int size;
	LinkedList<Integer> list;
	int sum;
	public void MovingAverage(int size) {
        this.size = size;
        list = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(list.size() == size) {
        	sum -= list.removeFirst();
        }
        
        sum += val;
        list.add(val);
        return (double)sum/list.size();
    }

}
