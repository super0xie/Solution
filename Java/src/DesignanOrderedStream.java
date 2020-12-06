import java.util.ArrayList;
import java.util.List;

public class DesignanOrderedStream {
	
	private String[] s;
	private int ptr = 0;
	public void OrderedStream(int n) {
        s = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        id--;
        s[id] = value;
        
        if(id == ptr) {
        	List<String> res = new ArrayList<>();
        	while(id < s.length && s[id] != null) {
        		res.add(s[id++]);
        	}
        	ptr = id;
        	return res;
        }else {
        	return new ArrayList<>();
        }
    }
}
