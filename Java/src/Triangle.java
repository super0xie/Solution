import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int [] previous;
        int [] current = new int [triangle.size()];
        
        for(int i = 0; i < triangle.size(); i++) {
        	previous = current;
        	current = new int [triangle.size()];
        	List<Integer> list = triangle.get(i);
        	for(int j = 0; j < list.size(); j++) {
        		if(j == 0)
        			current[j] = list.get(j) + previous[j];
        		else if(j == list.size()-1) {
        			current[j] = list.get(j) + previous[j-1];
        		}else {
        			current[j] = list.get(j) + Math.min(previous[j], previous[j-1]);
        		}
        	}
        }
        
        int result = Integer.MAX_VALUE;
        
        
        for(int i: current) {
        	if(i < result)
        		result = i;
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		Triangle test = new Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		System.out.println(test.minimumTotal(triangle));
		
	}

}
