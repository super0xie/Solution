import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<String>();
		char[] chars = s.toCharArray();
		
		
		for(int i = 0; i < s.length()-1; i++) {
			if(chars[i] == '+' && chars[i+1] == '+') {
				chars[i]='-';
				chars[i+1]='-';
				result.add(String.valueOf(chars));
				chars[i]='+';
				chars[i+1]='+';
			}
		}
		
		return result;
    }
}
