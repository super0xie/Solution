import java.util.HashMap;
import java.util.HashSet;

public class DesignPhoneDirectory {
	
	
//	private HashSet<Integer> inValid;
//	int n;
	private HashSet<Integer> valid;
	public void PhoneDirectory(int maxNumbers) {
		valid = new HashSet<Integer>();
		for(int i = 0; i < maxNumbers; i++) {
			valid.add(i);
		}
        
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if(valid.size() > 0) {
    		int toRemove = 0;
    		for(int i : valid) {
    			toRemove = i;
            	break;
            }
    		valid.remove(toRemove);
    		return toRemove;
    	}else {
    		return -1;
    	}
        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return valid.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        valid.add(number);
    }

}
