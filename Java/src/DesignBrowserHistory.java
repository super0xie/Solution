import java.util.ArrayList;

public class DesignBrowserHistory {
	
	private ArrayList<String> l = new ArrayList<>();
	private int idx = 0;
	public void BrowserHistory(String homepage) {
        l.add(homepage);
    }
    
    public void visit(String url) {
    	for(int i = l.size()-1; i > idx; i--) {
    		l.remove(i);
    	}
    	l.add(url);
    	idx++;
    }
    
    public String back(int steps) {
        idx-=steps;
        if(idx < 0) idx = 0;
        return l.get(idx);
    }
    
    public String forward(int steps) {
        idx += steps;
        if(idx >= l.size()) idx = l.size()-1;
        return l.get(idx);
    }
}
