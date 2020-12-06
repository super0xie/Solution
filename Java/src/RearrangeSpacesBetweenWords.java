import java.util.ArrayList;

public class RearrangeSpacesBetweenWords {
	public String reorderSpaces(String text) {
        ArrayList<String> l = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
        	if(text.charAt(i) == ' ') count++;
        	else {
        		int j = i+1;
        		while(j < text.length() && text.charAt(j) != ' ') j++;
        		l.add(text.substring(i, j));
        		i = j-1;
        	}
        }
        StringBuilder s = new StringBuilder();
        if(l.size() == 1) {
        	s.append(l.get(0));
        	for(int j = 0; j < count; j++) s.append(' ');
        	return s.toString();
        }
        
        int n = count / (l.size()-1);
        int e = count % (l.size()-1);
        
        
        for(int i = 0; i < l.size(); i++) {
        	s.append(l.get(i));
        	if(i != l.size()-1) {
        		for(int j = 0; j < n; j++) s.append(' ');
        	}
        }
        
        for(int j = 0; j < e; j++) s.append(' ');
        return s.toString();
    }
	
	public static void main(String[] args) {
		String text = "  this   is  a sentence ";
		RearrangeSpacesBetweenWords test = new RearrangeSpacesBetweenWords();
		test.reorderSpaces(text);
	}
}
