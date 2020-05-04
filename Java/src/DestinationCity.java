import java.util.HashSet;
import java.util.List;

public class DestinationCity {
	
	public String destCity(List<List<String>> paths) {
        HashSet<String> all = new HashSet<>();
        HashSet<String> start = new HashSet<>();
        
        for(List<String> p : paths) {
        	all.add(p.get(0));
        	start.add(p.get(0));
        	all.add(p.get(1));
        }
        
        for(String str : start) {
        	all.remove(str);
        }
        
        for(String str : all) return str;
        return null;
    }
}
