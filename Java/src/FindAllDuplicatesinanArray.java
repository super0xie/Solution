import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDuplicatesinanArray {
	
	public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> res = new HashSet<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        
        for(int i : nums) {
        	if(visited.contains(i)) res.add(i);
        	else visited.add(i);
        }
        List<Integer> l = new ArrayList<Integer>();
        for(int i : res) l.add(i);
        return l;
        
    }
}
