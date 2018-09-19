import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
	
	
	private HashMap<Integer, Integer> map;
	private int[] nums;
	public void RandomizedSet() {
		map = new HashMap<Integer, Integer>();
		nums = new int [20000];
    }
	
	public boolean insert(int val) {
	    if(!map.containsKey(val)) {
	        int idx = map.size();
	        nums[idx] = val;
	        map.put(val, idx);
	        return true;
	    }
	    return false;
	}
	
	public int getRandom() {
	    int idx = new Random().nextInt(map.size());
	    return nums[idx];
	}
	
	public boolean remove(int val) {
	    if(map.containsKey(val)) {
	        int idx = map.get(val);
	        int last = nums[map.size()-1];
	        nums[idx] = last;
	        map.put(last, idx);
	        map.remove(val);
	        return true;
	    }else {
	        return false;
	    }
	}
    
    public static void main(String[] args) {
    	InsertDeleteGetRandomO1 test = new InsertDeleteGetRandomO1();
    	test.RandomizedSet();
    	test.insert(1);
    	test.remove(2);
    	test.insert(2);
    	test.remove(1);
    	test.insert(2);
    	test.getRandom();
    	
    }

}
