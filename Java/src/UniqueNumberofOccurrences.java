import java.util.HashSet;

public class UniqueNumberofOccurrences {
	
	public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for(int i : arr) {
        	count[i+1000]++;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : count) {
        	if(i == 0) continue;
        	if(set.contains(i)) return false;
        	set.add(i);
        }
        
        return true;
    }
	
}
