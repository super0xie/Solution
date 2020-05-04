import java.util.LinkedList;

public class ReformatTheString {
	
	public String reformat(String s) {
        LinkedList<Character> l1 = new LinkedList<>();
        LinkedList<Character> l2 = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9') l1.add(s.charAt(i));
        	else l2.add(s.charAt(i));
        }
        
        if(Math.abs(l1.size()-l2.size()) > 1) return "";
        if(l1.size() < l2.size()) {
        	LinkedList<Character> tmp = l1;
        	l1 = l2;
        	l2 = tmp;
        }
        StringBuilder sb = new StringBuilder();
        while(!l1.isEmpty() || !l2.isEmpty()) {
        	sb.append(l1.poll());
        	if(!l2.isEmpty())
        		sb.append(l2.poll());
        }
        return sb.toString();
    }
	
}
