import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThroneInheritance {
	private String king;
	private HashSet<String> dead = new HashSet<>();
	private HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	public ThroneInheritance(String kingName) {
        this.king = kingName;
        map.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(res, king);
        return res;
    }
    
    private void dfs(List<String> list, String s) {
    	if(!dead.contains(s)) list.add(s);
    	for(String child : map.get(s)) dfs(list, child);
    }
}
