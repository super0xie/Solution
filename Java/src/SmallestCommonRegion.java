import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SmallestCommonRegion {
	
	public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		HashMap<String, String> map = new HashMap<>();
        for(List<String> l : regions) {
        	for(int i = 1; i < l.size(); i++) {
        		map.put(l.get(i), l.get(0));
        	}
        }
        
        HashSet<String> visited = new HashSet<>();
        visited.add(region1);
        visited.add(region2);
        LinkedList<String> q = new LinkedList<>();
        q.add(region1);
        q.add(region2);
        
        
        while(!q.isEmpty()) {
        	String str = q.poll();
        	
        	if(map.containsKey(str)) {
        		String parent = map.get(str);
        		if(visited.contains(parent)) return parent;
        		visited.add(parent);
        		q.add(parent);
        	}
        	
        	
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		SmallestCommonRegion test = new SmallestCommonRegion();
		List<List<String>> regions = Arrays.asList(
				Arrays.asList("Earth","North America","South America"), 
				Arrays.asList("North America","United States","Canada"),
				Arrays.asList("United States","New York","Boston"),
				Arrays.asList("Canada","Ontario","Quebec"),
				Arrays.asList("South America","Brazil"));
		
		System.out.println(test.findSmallestRegion(regions, "Quebec", "New York"));
	}
	
}
