import java.util.List;

public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
        if(words.get(0).length() != words.size()) return false;
        
        for(int i = 0; i < words.size(); i++) {
        	for(int j = 0; j < words.get(i).length(); j++) {
        		char c = words.get(i).charAt(j);
        		if(j >= words.size()) return false;
        		String tar = words.get(j);
        		if(tar.length() <= i) return false;
        		
        		char tarC = words.get(j).charAt(i);
        		if(c != tarC) return false;
        	}
        }
        
        return true;
        
    }
}
