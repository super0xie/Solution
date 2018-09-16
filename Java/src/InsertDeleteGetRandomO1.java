import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
	
	
	private HashMap<Integer, Integer> map;
	private int[] nums;
	private int size;
	private Random r;
	public void RandomizedSet() {
		map = new HashMap<Integer, Integer>();
		nums = new int [10000];
		r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
        	nums[size] = val;
        	map.put(val, size);
        	size++;
        	return true;
        }else {
        	return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(map.containsKey(val)) {
    		int idx = map.get(val);
    		map.remove(val);
    		size--;
    		if(size > 0) {
    			nums[idx] = nums[size];
        		map.put(nums[idx], idx);
    		}
    		
    		
    		return true;
    	}else {
    		return false;
    	}
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = r.nextInt(size);
        return nums[idx];
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
