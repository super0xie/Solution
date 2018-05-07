import java.util.ArrayList;
import java.util.Collections;

public class FindMedianFromDataStream {
	
	ArrayList<Integer> nums; 
	public void MedianFinder() {
        nums = new ArrayList<Integer>();
    }
	
	public FindMedianFromDataStream() {
        nums = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        int index = Collections.binarySearch(nums, num);
        
        if(index >= 0) {
        	nums.add(index, num);
        }else {
        	int insertPoint = -index - 1;
        	nums.add(insertPoint, num);
        }
        
        
    }
    
    public double findMedian() {
    	if(nums.size() == 0) return 0;
    	
        if(nums.size() % 2 != 0) {
        	return nums.get(nums.size() / 2);
        }else {
        	return ((double)(nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1))) / 2;
        }
    }
    
    public static void main(String[] args) {
    	FindMedianFromDataStream test = new FindMedianFromDataStream();
    	test.addNum(0);
    	test.addNum(0);
    	System.out.println(test.findMedian());
    	test.addNum(3);
    	System.out.println(test.findMedian());
    }

}
